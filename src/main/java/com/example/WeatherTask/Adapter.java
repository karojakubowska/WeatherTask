package com.example.WeatherTask;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
   private final RecyclerInterface recyclerInterface;
    Context context;
    public Cities cities;
    public ArrayList<CityModel> cityList;
   public Adapter(Context context,Cities c,RecyclerInterface recyclerInterface){
       this.context=context;
        this.cities=c;
        cityList=c.getCities();
        this.recyclerInterface=recyclerInterface;

   }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view,recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        ImageView Icon;
        TextView CityName= holder.CityName;
        TextView Weather=holder.Weather;
        CityName.setText(cityList.get(position).getCity());
        Weather.setText(cityList.get(position).getWeather());
         //
        if(Weather.getText().equals("rainy")){
            Icon=holder.itemView.findViewById(R.id.icon);
            Icon.setImageResource(R.drawable.ic_weather_drizzle_48_regular);
            Icon.setColorFilter(ContextCompat.getColor(context, R.color.rainyblue),
                    PorterDuff.Mode.MULTIPLY);
        }
        //
        if(Weather.getText().equals("cloudy")){
            Icon=holder.itemView.findViewById(R.id.icon);
            Icon.setImageResource(R.drawable.ic_weather_cloudy_48_regular);
            Icon.setColorFilter(ContextCompat.getColor(context, R.color.cloudgrey),
                    PorterDuff.Mode.MULTIPLY);
        }
        //
        if(Weather.getText().equals("sunny")){
            Icon=holder.itemView.findViewById(R.id.icon);
            Icon.setImageResource(R.drawable.ic_weather_sunny_16_regular);
            Icon.setColorFilter(ContextCompat.getColor(context, R.color.yellow),
                    PorterDuff.Mode.MULTIPLY);
        }
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView CityName;
        TextView Weather;

        @RequiresApi(api = Build.VERSION_CODES.N)
        public ViewHolder(@NonNull View itemView, RecyclerInterface recyclerInterface) {
            super(itemView);
            CityName=itemView.findViewById(R.id.txt_city);
            Weather=itemView.findViewById(R.id.txt_weather);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  if(recyclerInterface != null){
                    int position=getAdapterPosition();

                    if(position!=RecyclerView.NO_POSITION){
                        recyclerInterface.OnItemClick(position);
                    }
                  }
                }
            });
        }

    }
}
