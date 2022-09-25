package com.example.WeatherTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cities {

    private ArrayList<CityModel> Cities;

    Cities(){
        Cities = new ArrayList<>();
        fromJson(json);
    }
    ArrayList<CityModel> getCities(){
        return Cities;
    }
// region json data
    static String json="[" +
            "{" +
            "\"city\":\"Warsaw\","+
            "\"weather\":\"rainy\","+
            "\"hourly_temp\":["+
            "{ \"temp\":-2, \"hour\":0 },"+
            "{ \"temp\":-2, \"hour\":4 },"+
            "{ \"temp\":0.5, \"hour\":8 },"+
            "{ \"temp\":2, \"hour\":12 },"+
            "{ \"temp\":3, \"hour\":16 },"+
            "{ \"temp\":-1, \"hour\":20 }]"+
            " },"+
            "{\"city\":\"Paris\","+
            "\"weather\":\"cloudy\","+
            "\"hourly_temp\":["+
            "{ \"temp\":11, \"hour\":0 },"+
            "{ \"temp\":14, \"hour\":4 },"+
            "{ \"temp\":18, \"hour\":8 },"+
            "{ \"temp\":22, \"hour\":12 },"+
            "{ \"temp\":15, \"hour\":16 },"+
            "{ \"temp\":13, \"hour\":20 }]"+
            "},"+
            "{\"city\":\"Berlin\","+
            "\"weather\":\"sunny\","+
            "\"hourly_temp\":["+
            "{ \"temp\":-6, \"hour\":0 },"+
            "{ \"temp\":-4, \"hour\":4 },"+
            "{ \"temp\":2, \"hour\":8 },"+
            "{ \"temp\":4, \"hour\":12 },"+
            "{ \"temp\":5.5, \"hour\":16 },"+
            "{ \"temp\":3, \"hour\":20 }]"+
            "},"+

            "{\"city\":\"New York\","+
            "\"weather\":\"cloudy\","+
            "\"hourly_temp\":["+
            "{ \"temp\":12, \"hour\":0 },"+
            "{ \"temp\":13, \"hour\":4 },"+
            "{ \"temp\":12, \"hour\":8 },"+
            "{ \"temp\":15, \"hour\":12 },"+
            "{ \"temp\":16, \"hour\":16 },"+
            "{ \"temp\":14, \"hour\":20 }"+
            "]"+
            "}"+
            "]";
// endregion





    void fromJson(String json){
        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject dataArray = jsonArray.getJSONObject(i);
                String city = dataArray.getString("city");
                String weather = dataArray.getString("weather");
                CityModel CityData = new CityModel(city, weather);
                ArrayList<Temperature> temps = new ArrayList<>();

                JSONArray temperatures = dataArray.getJSONArray("hourly_temp");
                for (int k = 0; k < temperatures.length(); k++) {
                    try {
                        dataArray = temperatures.getJSONObject(k);
                        Double temp = dataArray.getDouble("temp");
                        Integer hour = dataArray.getInt("hour");
                        Temperature temperature = new Temperature(temp, hour);
                        temps.add(temperature);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                CityData.setHourly_temp(temps);
                Cities.add(CityData);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }}
    //1. Find the smallest temperature across all cities and print it,
    //2. For each city find its highest temperatures and print the results in format "city: max_temp",
    //3. Find the city with the smallest average daily temperature and print its name

    Double getLowestTemperature(){
        ArrayList<Double>LowestTemperatures=new ArrayList<>();
        for (CityModel c: Cities) {
            Double t =c.getLowestTemperature();
            LowestTemperatures.add(t);
        }
        Double x = LowestTemperatures.get(0);

        Double min = x;
        for (Double i: LowestTemperatures) {
            if(i<min){
                min= i;
            }
        }
        return min;


    }


    String getHighestTemperatureForEveryCity(){

        String txt="";
        for(int x=0;x<Cities.size();x++){
            CityModel c=Cities.get(x);
            txt+= c.getStringHighestTemp();
        }
        return txt;
    }

    Double getLowestAverageTemperature(){
        ArrayList<Double>LowestAverageTemperatures=new ArrayList<>();
        for (CityModel c: Cities) {
            Double t =c.getAverageTemperature();
            LowestAverageTemperatures.add(t);
        }
        Double x = LowestAverageTemperatures.get(0);

        Double min = x;
        for (Double i: LowestAverageTemperatures) {
            if(i<min){
                min= i;
            }
        }

        return min;
    }
    }


