package com.example.david_tepoche.androidynon1;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.david_tepoche.androidynon1.model.School;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ArrayList<School> schools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        schools = getIntent().getExtras().getParcelableArrayList("schools");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (School school : schools) {
            LatLng latLngSchool = new LatLng(Double.valueOf(school.getLatitude()), Double.valueOf(school.getLongitude()));
            if (school.getNbEleve() < 150) {
                mMap.addMarker(new MarkerOptions().position(latLngSchool).title(school.getNom()).snippet(school.getAddresse()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            } else if (school.getNbEleve() < 300) {
                mMap.addMarker(new MarkerOptions().position(latLngSchool).title(school.getNom()).snippet(school.getAddresse()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
            } else {
                mMap.addMarker(new MarkerOptions().position(latLngSchool).title(school.getNom()).snippet(school.getAddresse()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }
        }

        School schoolFocused = GetFocusedSchool(schools);
        if (schoolFocused != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(schoolFocused.getLatitude()), Double.valueOf(schoolFocused.getLongitude())), 15));
        } else {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(45.752845, 4.888221), 11));
        }
        mMap.setOnMarkerClickListener(this);
    }

    private School GetFocusedSchool(ArrayList<School> schools) {
        for (School school : schools) {
            if (school.isFocus()) {
                return school;
            }
        }
        return null;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 15));
        return true;
    }
}
