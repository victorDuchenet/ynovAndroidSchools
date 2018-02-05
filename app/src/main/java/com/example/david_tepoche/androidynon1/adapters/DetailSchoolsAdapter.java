package com.example.david_tepoche.androidynon1.adapters;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.david_tepoche.androidynon1.MapsActivity;
import com.example.david_tepoche.androidynon1.R;
import com.example.david_tepoche.androidynon1.model.School;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DetailSchoolsAdapter extends RecyclerView.Adapter<DetailSchoolsAdapter.MyViewHolder> {

    private ArrayList<School> schools;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_schools_row, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        School school = schools.get(position);
        holder.txvSchoolName.setText(school.getNom());
        holder.txvSchoolnbStudent.setText(String.valueOf(school.getNbEleve()));
        holder.txvSchoolLocation.setText(school.getAddresse());
        if (school.getNbEleve() < 150) {
            holder.lytNbStudentsInfo.setBackgroundColor(Color.GREEN);
        } else if (school.getNbEleve() < 300) {
            holder.lytNbStudentsInfo.setBackgroundColor(Color.rgb(255, 106, 34));
        }
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public DetailSchoolsAdapter(ArrayList<School> schools) {
        this.schools = schools;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txvSchoolName, txvSchoolLocation, txvSchoolnbStudent;
        public ConstraintLayout lytNbStudentsInfo;

        public MyViewHolder(View view) {
            super(view);
            txvSchoolLocation = view.findViewById(R.id.txv_location);
            txvSchoolName = view.findViewById(R.id.txv_school_name);
            txvSchoolnbStudent = view.findViewById(R.id.txv_nb_student);
            lytNbStudentsInfo = view.findViewById(R.id.layout_Background_NbStudents);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), MapsActivity.class);

            SetFocusInOneSchool(schools, getAdapterPosition());
            schools.get(getAdapterPosition()).setFocus(true);
            intent.putParcelableArrayListExtra("schools", schools);
            view.getContext().startActivity(intent);
        }

        private void SetFocusInOneSchool(ArrayList<School> schools, int adapterPosition) {
            for (School school: schools) {
                school.setFocus(false);
            }

            schools.get(adapterPosition).setFocus(true);
        }
    }
}


