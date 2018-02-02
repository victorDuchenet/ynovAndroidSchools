package com.example.david_tepoche.androidynon1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.david_tepoche.androidynon1.R;
import com.example.david_tepoche.androidynon1.model.School;

import java.io.Serializable;
import java.util.List;

public class detailSchoolsAdapter extends ArrayAdapter<School> implements Serializable {

    private List<School> schools;
    private Context context;


    public detailSchoolsAdapter(List<School> schools, Context context){
        super(context, R.layout.activity_detail_schools, schools);
        this.schools = schools;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final School item = getItem(position);
        final ViewHolder viewHolder;


}

    // View lookup cache
    private static class ViewHolder {
       //
    }