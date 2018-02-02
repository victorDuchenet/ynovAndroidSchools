package com.example.david_tepoche.androidynon1.model;

/**
 * Created by David_tepoche on 02/02/2018.
 */

public class School {

    private String nom;
    private String addresse;
    private Integer nbEleve;
    private Integer status;
    private String latitude;
    private String longitude;

    public School() {
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
}
