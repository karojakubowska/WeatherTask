package com.example.WeatherTask;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerInterface{
    Cities cities=new Cities();
    ImageButton btn_stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#4D4A4A'>Weather Task </font>"));

        btn_stats=findViewById(R.id.button_stats);
        btn_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, StatsActivity.class);
                startActivity(myIntent);
            }
        });

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        Adapter adapter=new Adapter(MainActivity.this,cities,this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void OnItemClick(int position) {
    Intent intent =new Intent(MainActivity.this,DetailActivity.class);
    ArrayList<CityModel> data=new ArrayList<>();
    data=cities.getCities();

    intent.putExtra("City",data.get(position).getCity());
    intent.putExtra("Weather",data.get(position).getWeather());
    String pos=String.valueOf(position);
    intent.putExtra("Position", pos);
   /* ArrayList<Temperature> datas = data.get(position).hourly_temp;
    // Object class does not implement Serializable interface

        Bundle extra = new Bundle();
        extra.putSerializable("data", datas);

        Intent intent2 = new Intent(getBaseContext(), DetailActivity.class);
        intent.putExtra("extra", extra);*/


   startActivity(intent);
    }
}