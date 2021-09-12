package com.example.finalproject;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SecondFragment extends Fragment {

    private String jwtToken = "";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity mn = (MainActivity) getActivity();
        jwtToken = mn.getToken();
        final EditText filmName = view.findViewById(R.id.film_name);
        final EditText filmRating = view.findViewById(R.id.film_rating);
        Snackbar greenBar = Snackbar.make(view, "", 3000);
        View greenBarView = greenBar.getView();
        greenBarView.setBackgroundColor(Color.parseColor("#66bb6a"));
        final Snackbar successBar = greenBar;
        Snackbar redBar = Snackbar.make(view, "", 3000);
        View redBarView = redBar.getView();
        redBarView.setBackgroundColor(Color.parseColor("#d32f2f"));
        final Snackbar failBar = redBar;
        final TableLayout tl = view.findViewById(R.id.my_table);

        view.findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String f_name = filmName.getText().toString();
                String f_rating = filmRating.getText().toString();

                if (f_rating.isEmpty()) {
                    failBar.setText("Please enter a Rating");
                    failBar.show();
                }
                if (f_name.isEmpty()) {
                    failBar.setText("Please enter a film name");
                    failBar.show();
                }
                if (!f_rating.isEmpty() && !f_rating.isEmpty()) {
                    String regexStr = "^[0-9]*$";
                    if(f_rating.trim().matches(regexStr)) {
                        Double d = Double.valueOf(f_rating);
                        if(d >= 0 && d <=10) {
                            try {
                                JSONObject jsonOutput = new JSONObject();
                                jsonOutput.put("name", f_name);
                                jsonOutput.put("rating", f_rating);
                                URL url = new URL("http://192.168.0.161:8080/api/v1/films");
                                HttpURLConnection hc = (HttpURLConnection) url.openConnection();
                                hc.setRequestMethod("POST");
                                hc.setRequestProperty("Accept", "application/json");
                                hc.setRequestProperty("Content-Type", "application/json");
                                hc.setRequestProperty("Authorization", "Bearer " + jwtToken);
                                hc.setDoOutput(true);
                                String out = jsonOutput.toString();
                                OutputStreamWriter wr = new OutputStreamWriter(hc.getOutputStream());
                                wr.write(out);
                                wr.flush();
                                wr.close();
                                if (hc.getResponseCode() == 200) {
                                    filmName.setText("");
                                    filmRating.setText("");
                                    successBar.setText("Film and rating has been submitted");
                                    successBar.show();
                                }
                                else if (hc.getResponseCode() == 403) {
                                    failBar.setText("You must login first");
                                    failBar.show();
                                }
                                hc.disconnect();
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (ProtocolException e) {
                                e.printStackTrace();
                            } catch (IOException | JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        else {
                            failBar.setText("Please enter a valid film Rating(0-10)");
                            failBar.show();
                        }
                    }
                    else{
                        failBar.setText("Please enter a valid film Rating(0-10)");
                        failBar.show();
                    }
                }




            }
        });

        view.findViewById(R.id.button_show).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int c = 0;
                try {
                    URL url = new URL("http://192.168.0.161:8080/api/v1/films");
                    HttpURLConnection hc = (HttpURLConnection) url.openConnection();
                    hc.setRequestMethod("GET");
                    hc.setRequestProperty("Accept", "application/json");
                    hc.setRequestProperty("Content-Type", "application/json");
                    tl.removeAllViews();
                    InputStream responseBody = hc.getInputStream();
                    InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                    JsonReader jsonreader = new JsonReader(responseBodyReader);
                    TableRow th = new TableRow(getActivity());
                    th.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
                    TextView f_name = new TextView(getActivity());
                    TextView f_rating = new TextView(getActivity());
                    jsonreader.beginArray();
                    while (jsonreader.hasNext()) {
                        if (c==0) {
                            f_name.setText("Film name");
                            f_name.setTypeface(f_name.getTypeface(), Typeface.BOLD);
                            f_name.setTextSize(19);
                            f_name.setPadding(66, 3, 66, 3);
                            f_rating.setText("Rating");
                            f_rating.setTypeface(f_rating.getTypeface(), Typeface.BOLD);
                            f_rating.setTextSize(19);
                            f_rating.setPadding(66, 3, 66, 3);
                            th.addView(f_name);
                            th.addView(f_rating);
                            tl.addView(th);
                            c = 1;
                        }
                        jsonreader.beginObject();
                        TableRow tr = new TableRow(getActivity());
                        tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
                        while (jsonreader.hasNext()) {
                            final String name = jsonreader.nextName();
                            if (name.equals("name")) {
                                TextView tv_name = new TextView(getActivity());
                                tv_name.setTypeface(tv_name.getTypeface(), Typeface.BOLD);
                                tv_name.setTextSize(16);
                                tv_name.setPadding(66, 3, 66, 3);
                                tv_name.setText(jsonreader.nextString());
                                tr.addView(tv_name);
                            } else if (name.equals("rating")) {
                                EditText et_rating = new EditText(getActivity());
                                et_rating.setBackground(null);
                                et_rating.setPadding(66, 3, 66, 3);
                                et_rating.setTextSize(16);
                                et_rating.setText(jsonreader.nextString());
                                Button bt_update = new Button(getActivity());
                                bt_update.setPadding(66, 3, 66, 3);
                                bt_update.setText("Update");
                                bt_update.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                            for(int i = 1, j = tl.getChildCount(); i < j; i++) {
                                                View view = tl.getChildAt(i);
                                                TableRow tr = (TableRow) view;
                                                TextView name_view = (TextView) tr.getChildAt(0);
                                                String updated_name = name_view.getText().toString();
                                                EditText rating_view = (EditText) tr.getChildAt(1);
                                                String updated_rating = rating_view.getText().toString();
                                                String regexStr = "^[0-9]*$";
                                                if(updated_rating.trim().matches(regexStr) && !updated_rating.isEmpty()) {
                                                    Double d = Double.valueOf(updated_rating);
                                                    if(d >= 0 && d <=10) {
                                                        try {
                                                            JSONObject jsonOutput = new JSONObject();
                                                            jsonOutput.put("name", updated_name);
                                                            jsonOutput.put("rating", updated_rating);
                                                            URL url = new URL("http://192.168.0.161:8080/api/v1/films");
                                                            HttpURLConnection hc = (HttpURLConnection) url.openConnection();
                                                            hc.setRequestMethod("PUT");
                                                            hc.setRequestProperty("Accept", "application/json");
                                                            hc.setRequestProperty("Content-Type", "application/json");
                                                            hc.setRequestProperty("Authorization", "Bearer " + jwtToken);
                                                            hc.setDoInput(true);
                                                            hc.setDoOutput(true);
                                                            String out = jsonOutput.toString();
                                                            OutputStreamWriter wr = new OutputStreamWriter(hc.getOutputStream());
                                                            wr.write(out);
                                                            wr.flush();
                                                            wr.close();
                                                            if (hc.getResponseCode() == 200) {
                                                                if (i == j-1) {
                                                                    successBar.setText("Rating has been updated");
                                                                    successBar.show();
                                                                }
                                                            }
                                                            else if (hc.getResponseCode() == 403) {
                                                                failBar.setText("You must login first");
                                                                failBar.show();
                                                            }
                                                            hc.disconnect();
                                                        } catch (IOException e) {
                                                            e.printStackTrace();
                                                        } catch (JSONException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                    else {
                                                        failBar.setText("Invalid Rating");
                                                        failBar.show();
                                                        break;
                                                    }
                                                }
                                                else {
                                                    failBar.setText("Invalid Rating");
                                                    failBar.show();
                                                    break;
                                                }

                                            }
                                    }
                                });
                                tr.addView(et_rating);
                                tr.addView(bt_update);
                                tl.addView(tr);
                            } else {
                                jsonreader.skipValue();
                            }
                        }
                        jsonreader.endObject();
                    }
                    jsonreader.endArray();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}