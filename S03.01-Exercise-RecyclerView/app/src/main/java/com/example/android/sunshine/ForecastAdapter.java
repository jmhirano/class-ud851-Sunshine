package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by J on 1/31/2018.
 */
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// COMPLETE (15) Add a class file called ForecastAdapter
// COMPLETE (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
public class ForecastAdapter extends  RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    // COMPLETE (23) Create a private string array called mWeatherData
    private String mWeatherData[];
    // COMPLETE (47) Create the default constructor (we will pass in parameters in a later lesson)
    public ForecastAdapter() {
        super();
    }
    // COMPLETE (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // COMPLETE (17) Extend RecyclerView.ViewHolder
    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
        // COMPLETE (18) Create a public final TextView variable called mWeatherTextView
        public final TextView mWeatherTextView;
        // COMPLETE (19) Create a constructor for this class that accepts a View as a parameter
        public ForecastAdapterViewHolder(View view) {
            // COMPLETE (20) Call super(view) within the constructor for ForecastAdapterViewHolder
            super(view);
            // COMPLETE (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
    }
    // COMPLETE (24) Override onCreateViewHolder
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // COMPLETE (25) Within onCreateViewHolder, inflate the list item xml into a view
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.forecast_list_item, parent, false);
        // COMPLETE (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
        return new ForecastAdapterViewHolder(view);
    }
    // COMPLETE (27) Override onBindViewHolder
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        // COMPLETE (28) Set the text of the TextView to the weather for this list item's position
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    // COMPLETE (29) Override getItemCount
    @Override
    public int getItemCount() {
        // COMPLETE (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
        if(mWeatherData == null) return 0;
        else return mWeatherData.length;
    }

    // COMPLETE (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        // COMPLETE (32) After you save mWeatherData, call notifyDataSetChanged
        notifyDataSetChanged();
    }
    // Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
}
