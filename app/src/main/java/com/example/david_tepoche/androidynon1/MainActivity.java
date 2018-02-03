package com.example.david_tepoche.androidynon1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.david_tepoche.androidynon1.model.School;
import com.example.david_tepoche.androidynon1.rest.ISchoolService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public List<School> schools;

    private Button btnDetailSchools;
    private Button btnMapSchools;
    private ArrayList<School> schoolsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDetailSchools = findViewById(R.id.btn_list_school);
        btnMapSchools = findViewById(R.id.btn_map_school);

        ISchoolService schoolService = ISchoolService.retrofit.create(ISchoolService.class);
        Call<List<School>> call = schoolService.listSchool();

        btnDetailSchools.setEnabled(false);

        call.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                schools = response.body();

                //need to convert List<School> in arraylist to put schools through activity (intent)
                schoolsArray = (ArrayList<School>) schools;
                btnDetailSchools.setEnabled(true);
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Probleme lors de la recuperation des écoles",Toast.LENGTH_LONG).show();
            }
        });

        btnMapSchools.setOnClickListener(this);
        btnDetailSchools.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        if (v.getId() == R.id.btn_list_school) {
            intent = new Intent(MainActivity.this, DetailSchoolsActivity.class);
        }
        if (v.getId() == R.id.btn_map_school) {
            intent = new Intent(MainActivity.this, MapsActivity.class);
        }
        intent.putParcelableArrayListExtra("schools", schoolsArray);
        startActivity(intent);
    }
}

