package com.example.david_tepoche.androidynon1.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by David_tepoche on 02/02/2018.
 */

public class School implements Parcelable{

    private String nom;
    private String addresse;
    private Integer nbEleve;
    private Integer status;
    private String latitude;
    private String longitude;

    public School() {

    }

    public School(String nom, String addresse, Integer nbEleve, Integer status) {
        this.nom = nom;
        this.addresse = addresse;
        this.nbEleve = nbEleve;
        this.status = status;
    }

    public School(Parcel parcel){
        nom = parcel.readString();
        addresse = parcel.readString();
        nbEleve = Integer.valueOf(parcel.readString());
        status = Integer.valueOf(parcel.readString());
        latitude = parcel.readString();
        longitude = parcel.readString();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public Integer getNbEleve() {
        return nbEleve;
    }

    public void setNbEleve(Integer nbEleve) {
        this.nbEleve = nbEleve;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeString(addresse);
        parcel.writeString(String.valueOf(nbEleve));
        parcel.writeString(String.valueOf(status));
        parcel.writeString(latitude);
        parcel.writeString(longitude);
    }

    public static final Parcelable.Creator<School> CREATOR = new Parcelable.Creator<School>() {

        @Override
        public School createFromParcel(Parcel parcel) {
            return new School(parcel);
        }

        @Override
        public School[] newArray(int i) {
            return new School[0];
        }
    };
}
