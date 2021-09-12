# Assignment Requirements

1.  The app should load data from http://interviewtest.getguru.com/seismic/data.json. This data comes in the form of an array of earthquakes. An earthquake looks something like this.

```json
{
  "time": "2017-09-08T12:46:04.610Z",
  "latitude": 15.348,
  "longitude": -93.9526,
  "depth": 66.08,
  "mag": 4.7,
  "magType": "mb",
  "id": "us2000ai1z",
  "place": "72km SW of Tres Picos, Mexico",
  "type": "earthquake"
}
```

2.  The app should render these earthquakes as a table with each earthquake as a row. However, there are some very specific rules that need to be followed

    1.  There should be a text input that allows the user to filter the earthquakes by **place**. Not by any other field.
    2.  You should sort the earthquakes by **highest magnitude to lowest magnitude**. In the event some earthquakes share the same magnitude, **the most recent ones should win.**
    3.  After sorting and filtering the earthquakes, you should show no more than 20 results. **Pagination is not required.**

3.  Each earthquake should show the following columns exactly like this

| id         | time                  | place                            | magnitude | more      |
| ---------- | --------------------- | -------------------------------- | --------- | --------- |
| us2000ai1z | July 25, 2017 @ 19:23 | 228km SSW of Bengkulu, Indonesia | 5.3       | [Details] |

4.  The details column should render a button that says details. Clicking on it should show you the longitude and latitude for the earthquake.
5.  The time column should be formatted as shown above.
