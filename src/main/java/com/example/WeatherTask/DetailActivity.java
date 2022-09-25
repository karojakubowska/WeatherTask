package com.example.WeatherTask;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#4D4A4A'>Weather Task </font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String CityName=getIntent().getStringExtra("City");
        String Weather=getIntent().getStringExtra("Weather");
        String position=getIntent().getStringExtra("Position");
        Integer pos=Integer.parseInt(position);

        Cities cities=new Cities();
        ArrayList<CityModel>cityModelArrayList=cities.getCities();
        ArrayList<Temperature> temps=cityModelArrayList.get(pos).getHourly_temp();




        l = findViewById(R.id.list);
        ArrayAdapter<Temperature> arr;
        arr= new ArrayAdapter<Temperature>(this,R.layout.support_simple_spinner_dropdown_item, temps);
        l.setAdapter(arr);



        TextView txt_city=findViewById(R.id.txt_cityname);
        TextView txt_weather=findViewById(R.id.txt_weather);



        txt_city.setText(CityName);
        txt_weather.setText(Weather);

    }
}