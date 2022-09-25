package com.example.WeatherTask;

import java.util.ArrayList;

public class CityModel {

    private String City;
    private String Weather;
    private ArrayList<Temperature>hourly_temp;

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    CityModel(String city,String weather){
        City=city;
        Weather=weather;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }

    public ArrayList<Temperature> getHourly_temp(){
        return hourly_temp;
    }
    public void setHourly_temp(ArrayList<Temperature> temps){
        hourly_temp=temps;
    }


    public Double getLowestTemperatureForCity(){
        Temperature x = hourly_temp.get(0);
        Double min = x.getTemp();
        for (Temperature t: hourly_temp) {
            if(t.getTemp()<min){
                min= t.getTemp();
            }
        }
        return min;
    }
    public Double getLowestTemperature(){
        Temperature x = hourly_temp.get(0);
        Double min = x.getTemp();
        for (Temperature t: hourly_temp) {
            if(t.getTemp()<min){
                min= t.getTemp();
            }
        }
        return min;
    }
    public Double getHighestTemperature(){
        Temperature x = hourly_temp.get(0);
        Double max = x.getTemp();
        for (Temperature t: hourly_temp) {
            if(t.getTemp()>max){
                max= t.getTemp();
            }
        }
        return max;
    }

    public Double getAverageTemperature(){
        Double sum=0.0;
        Double average=0.0;
        for (Temperature t: hourly_temp){
            sum+=t.getTemp();
        }
        average=sum/hourly_temp.size();
        return average;
    }

    String getStringHighestTemp(){
        return City+" : "+getHighestTemperature().toString()+"°\n";
    }
}
