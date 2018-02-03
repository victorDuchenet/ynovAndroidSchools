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

        List<School> schools = new ArrayList<School>();
        schools.add(new School("fdsf","fdsf",11,1));
        schools.add(new School("kjkk","cc",11,2));
        schools.add(new School("rere","rrer",1,1));
        schools.add(new School("nom","adress",21212,1));

        RecyclerView recyclerView = findViewById(R.id.rcv_details_schools);

        DetailSchoolsAdapter detailSchoolsAdapter = new DetailSchoolsAdapter(schools);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(detailSchoolsAdapter);
        detailSchoolsAdapter.notifyDataSetChanged();
    }
}
