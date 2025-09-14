package com.example.googlemapactivity;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapactivity.databinding.ActivityGoogleMapsBinding;

import java.io.IOException;
import java.util.List;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGoogleMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGoogleMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void Search(View view) {
        EditText loSearch = findViewById(R.id.editText);
        String location = loSearch.getText().toString();
        List<Address> addressList = null;
        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title("My Location"));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

            }
            catch(Exception e)
            {}
            
        } else {
            Toast.makeText(this, "Enter Location", Toast.LENGTH_SHORT).show();
        }
    }
/*
  public void Search(View view) {
      EditText loSearch = findViewById(R.id.editText);
      String location = loSearch.getText().toString().trim(); // Trim the location string to remove leading/trailing spaces
      List<Address> addressList = null;
      if (!location.isEmpty()) { // Checking if location is not empty
          Geocoder geocoder = new Geocoder(this);
          try {
              addressList = geocoder.getFromLocationName(location, 20);
              if (addressList != null && !addressList.isEmpty()) { // Check if addressList is not null or empty
                  Address address = addressList.get(0);
                  LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                  mMap.addMarker(new MarkerOptions().position(latLng).title("My Location"));
                  mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
              } else {
                  Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
              }
          } catch (IOException e) {
              e.printStackTrace();
              Toast.makeText(this, "Geocoder error", Toast.LENGTH_SHORT).show();
          }
      } else {
          Toast.makeText(this, "Enter Location", Toast.LENGTH_SHORT).show();
      }
  }
*/



    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);


    }

    public void Normal(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }

    public void satellite(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void terrain(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    public void hybrid(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
