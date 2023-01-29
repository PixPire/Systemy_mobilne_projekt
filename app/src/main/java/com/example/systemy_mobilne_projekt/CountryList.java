package com.example.systemy_mobilne_projekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.systemy_mobilne_projekt.adapters.CountryAdapter;
import com.example.systemy_mobilne_projekt.model.CountryModel;
import com.example.systemy_mobilne_projekt.model.Result;
import com.example.systemy_mobilne_projekt.service.GetCountryDataService;
import com.example.systemy_mobilne_projekt.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryList extends AppCompatActivity {


    ArrayList<CountryModel> countries;

    private CountryAdapter countryAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        GetCountries();
    }

    public Object GetCountries(){
        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Result> call = getCountryDataService.getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if(result!=null && result.getResult() !=null){
                    countries=(ArrayList<CountryModel>) result.getResult();

                   ViewData();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        return countries;
    }

    private void ViewData() {
        recyclerView=findViewById(R.id.recyclerView);
        countryAdapter=new CountryAdapter(countries);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CountryList.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);

    }

}