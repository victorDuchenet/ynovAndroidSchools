package com.example.david_tepoche.androidynon1.rest;

import com.example.david_tepoche.androidynon1.model.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


/**
 * Created by David_tepoche on 02/02/2018.
 */

public interface ISchoolService {
    public static final String ENDPOINT = "http://192.168.137.174:8080/";

    @GET("getEcolePrimaire")
    Call<List<School>> listSchool();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
