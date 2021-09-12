package com.example.finalproject;

import android.graphics.Color;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class FirstFragment extends Fragment {

    private String jwtToken;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView tv = view.findViewById(R.id.pleaseLogin);
        final EditText et = view.findViewById(R.id.loginInput);
        Snackbar greenBar = Snackbar.make(view, "", 3000);
        View greenBarView = greenBar.getView();
        greenBarView.setBackgroundColor(Color.parseColor("#66bb6a"));
        final Snackbar successBar =  greenBar;
        final Snackbar redBar = Snackbar.make(view, "", 3000);
        View redBarView = redBar.getView();
        redBarView.setBackgroundColor(Color.parseColor("#d32f2f"));
        final Snackbar failBar =  redBar;

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String nameInput = et.getText().toString();

                if (nameInput.isEmpty()) {
                    failBar.setText("You haven't login");
                    failBar.show();
                } else {
                    try {
                        JSONObject jsonOutput = new JSONObject();
                        jsonOutput.put("username", nameInput);
                        URL url = new URL("http://192.168.0.161:8080/api/v1/login");
                        HttpURLConnection hc = (HttpURLConnection) url.openConnection();
                        hc.setRequestMethod("POST");
                        hc.setRequestProperty("Content-Type", "application/json");
                        hc.setRequestProperty("Accept", "application/json");
                        hc.setDoInput(true);
                        hc.setDoOutput(true);
                        String out = jsonOutput.toString();
                        OutputStreamWriter wr = new OutputStreamWriter(hc.getOutputStream());
                        wr.write(out);
                        wr.flush();
                        wr.close();
                        if (hc.getResponseCode() == 200) {
                            successBar.setText("You have logged in");
                            successBar.show();
                            InputStream responseBody = hc.getInputStream();
                            InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                            JsonReader jsonreader = new JsonReader(responseBodyReader);
                            jsonreader.beginObject();
                            while (jsonreader.hasNext()) {
                                String name = jsonreader.nextName();
                                if (name.equals("token")) {
                                    jwtToken = jsonreader.nextString();
                                }
                            }
                            MainActivity mn = (MainActivity) getActivity();
                            mn.setToken(jwtToken);
                            hc.disconnect();
                        } else if (hc.getResponseCode() == 403){
                            failBar.setText("You must login first");
                            failBar.show();
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}