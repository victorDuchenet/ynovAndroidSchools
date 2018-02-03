package com.example.david_tepoche.androidynon1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.david_tepoche.androidynon1.R;
import com.example.david_tepoche.androidynon1.adapters.DetailSchoolsAdapter;
import com.example.david_tepoche.androidynon1.model.School;

import java.util.ArrayList;
import java.util.List;

public class DetailSchoolsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schools);

        ArrayList<School> schools = getIntent().getExtras().getParcelableArrayList("schools");

        RecyclerView recyclerView = findViewById(R.id.rcv_details_schools);

        DetailSchoolsAdapter detailSchoolsAdapter = new DetailSchoolsAdapter(schools);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(detailSchoolsAdapter);
        detailSchoolsAdapter.notifyDataSetChanged();
    }
}
