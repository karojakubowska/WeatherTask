package com.example.WeatherTask;

import java.io.Serializable;

public class Temperature implements Serializable {

    private Double Temp;
    private Integer Hour;

    Temperature(Double temp,Integer hour ){
        Temp=temp;
        Hour=hour;
    }
    public Double getTemp() {
        return Temp;
    }
    public void setTemp(Double temp) {
        Temp = temp;
    }

    public Integer getHour() {
        return Hour;
    }
    public void setHour(Integer hour) {
        Hour = hour;
    }


    @Override
    public String toString() {

        return "Noted at "+Hour.toString()+":00 "+" temperature: "+Temp.toString()+"°";
    }
}
