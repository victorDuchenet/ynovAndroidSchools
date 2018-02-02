package com.example.david_tepoche.androidynon1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.david_tepoche.androidynon1.model.School;
import com.example.david_tepoche.androidynon1.rest.DetailSchoolsActivity;
import com.example.david_tepoche.androidynon1.rest.ISchoolService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public List<School> schools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ISchoolService schoolService = ISchoolService.retrofit.create(ISchoolService.class);
        Call<List<School>> call = schoolService.listSchool();


        call.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                schools = response.body();
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_list_school){
            Intent intentActivitySchoolsDetail = new Intent(MainActivity.this, DetailSchoolsActivity.class);
            startActivity(intentActivitySchoolsDetail);
        }
        if(v.getId() == R.id.btn_map_school){
            Intent intentMapActivity = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intentMapActivity);
        }

    }
}

