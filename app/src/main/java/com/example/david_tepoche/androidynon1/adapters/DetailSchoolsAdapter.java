package com.example.david_tepoche.androidynon1.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david_tepoche.androidynon1.R;
import com.example.david_tepoche.androidynon1.model.School;

import java.util.List;

public class DetailSchoolsAdapter extends RecyclerView.Adapter<DetailSchoolsAdapter.MyViewHolder> {

    private List<School> schools;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_schools_row,parent,false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        School school = schools.get(position);
        holder.txvSchoolName.setText(school.getNom());
        holder.txvSchoolnbStudent.setText(String.valueOf(school.getNbEleve()));
        holder.txvSchoolLocation.setText(school.getAddresse());
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public DetailSchoolsAdapter(List<School> schools) {
        this.schools = schools;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txvSchoolName, txvSchoolLocation, txvSchoolnbStudent;

        public MyViewHolder(View view) {
            super(view);
            txvSchoolLocation =  view.findViewById(R.id.txv_location);
            txvSchoolName =  view.findViewById(R.id.txv_school_name);
            txvSchoolnbStudent = view.findViewById(R.id.txv_nb_student);
        }
    }
}


