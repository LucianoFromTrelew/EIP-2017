package com.example.developer.pruebaapi;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MainActivity extends AppCompatActivity
        implements GoogleApiClient.ConnectionCallbacks {

    private static final int REQUEST_LOCATION_CODE = 500;
    private GoogleApiClient mGAC;
    private Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGAC = new GoogleApiClient
                .Builder(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mGAC.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGAC.disconnect();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION_CODE) {
            this.lastLocation();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, REQUEST_LOCATION_CODE);
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        } else {
            this.lastLocation();
        }
    }

    private void lastLocation(){
        this.mLastLocation = LocationServices.FusedLocationApi.getLastLocation(this.mGAC);
    }

    public void showLocation(View view){
//        LocationServices.FusedLocationApi.
        TextView tv = (TextView) findViewById(R.id.texto);
        tv.setText(String.format("%s, %s",
                mLastLocation.getLatitude(),
                mLastLocation.getLongitude()));
    }

    @Override
    public void onConnectionSuspended(int i) {
        return;
    }
}
