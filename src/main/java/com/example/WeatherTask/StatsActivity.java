package com.example.WeatherTask;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {
    Button btn_stats;
    Cities cities;
    TextView txtLowestTemp;
    TextView txtLowestAverageTemp;
    TextView txtHighestForAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#4D4A4A'>Weather Task </font>"));
        txtLowestTemp =findViewById(R.id.placeTxt);
        txtLowestAverageTemp = findViewById(R.id.scoreTxt);
        txtHighestForAll=findViewById(R.id.highest);
        cities=new Cities();
        
        Double lowestTemp=cities.getLowestTemperature();
        txtLowestTemp.setText(lowestTemp.toString()+"°");

        Double lowestAverageTemp=cities.getLowestAverageTemperature();
        txtLowestAverageTemp.setText(String.format("%.2f°", lowestAverageTemp));

        String highestTemperatures=cities.getHighestTemperatureForEveryCity();
        txtHighestForAll.setText(highestTemperatures);
    }
}