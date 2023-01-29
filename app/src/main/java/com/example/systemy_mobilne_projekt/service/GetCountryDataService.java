package com.example.systemy_mobilne_projekt.service;

import com.example.systemy_mobilne_projekt.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {


    @GET("countries")
    Call<Result> getResult();


}
