package com.example.systemy_mobilne_projekt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<CurrencyModelClass> {

    private ArrayList<CurrencyModelClass> currencyArrayList;
    Context context;

    public CustomAdapter(ArrayList<CurrencyModelClass> data, Context context){
        super(context, R.layout.activity_converter, data);
        this.currencyArrayList = data;
        this.context=context;
    }

    // View Lookup Cache
    private static class ViewHolder{
        TextView currencyName;
        TextView currencyShort;
        TextView currencyValue;
    }





}
