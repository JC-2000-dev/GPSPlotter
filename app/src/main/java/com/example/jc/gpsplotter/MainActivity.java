package com.example.jc.gpsplotter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    String myProvider;

    private double currentLong;
    private  double currentLat;
    double varLong1;
    double varLat1;
    double varLong2;
    double varLat2;
    double varLong3;
    double varLat3;
    double varLong4;
    double varLat4;
    double varLong5;
    double varLat5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE); // Choose your accuracy requirement.

        myProvider = locationManager.getBestProvider(criteria, true);



        if (myProvider != null && !myProvider.equals("")) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                     {
                return;
            }
            Location location = locationManager.getLastKnownLocation(myProvider);
            locationManager.requestLocationUpdates(myProvider, 150, 0, this);


            if (location != null)
                onLocationChanged(location);
            else
                Toast.makeText(getBaseContext(), "No Location Provider Found Check Your Code", Toast.LENGTH_LONG).show();


        }

   /////Buttons/////////
        final Button button1 = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);
        final Button button3 = (Button)findViewById(R.id.button3);
        final Button button4 = (Button)findViewById(R.id.button4);
        final Button button5 = (Button)findViewById(R.id.button5);
        assert button1 != null;
        assert button2 != null;
        assert button3 != null;
        assert button4 != null;
        assert button5 != null;


        ///Button1 Listener////////
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                varLong1 = (currentLong);
                varLat1 = (currentLat);
                TextView longitude = (TextView) findViewById(R.id.fixLong1);
                TextView latitude = (TextView) findViewById(R.id.fixLat1);

                String stringLong = Double.toString(currentLong);
                String stringLat = Double.toString(currentLat);

                assert longitude != null;
                longitude.setText(stringLong);
                assert latitude != null;
                latitude.setText(stringLat);


                button1.setTextColor(Color.RED);
                button2.setVisibility(view.VISIBLE);

            }
        });


        ///Button2 Listener////////
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                varLong2 = (currentLong);
                varLat2 = (currentLat);
                TextView longitude = (TextView) findViewById(R.id.fixLong2);
                TextView latitude = (TextView) findViewById(R.id.fixLat2);

                String stringLong = Double.toString(currentLong);
                String stringLat = Double.toString(currentLat);

                assert longitude != null;
                longitude.setText(stringLong);
                assert latitude != null;
                latitude.setText(stringLat);


                button2.setTextColor(Color.RED);
                button3.setVisibility(view.VISIBLE);
                TextView long2 = (TextView)findViewById(R.id.textLong2);
                TextView lat2 = (TextView)findViewById(R.id.textLat2);
                long2.setVisibility(view.VISIBLE);
                lat2.setVisibility(view.VISIBLE);


                //calculate dist between 1_2///

                double r = 6371000; // metres
                double φ1 = Math.toRadians(varLat1);
                double φ2 = Math.toRadians(varLat2);
                double Δφ = Math.toRadians(varLat2-varLat1);
                double Δλ = Math.toRadians(varLong2-varLong1);

                double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
                        Math.cos(φ1) * Math.cos(φ2) *
                               Math.sin(Δλ/2) * Math.sin(Δλ/2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

                double  d = r * c;
                d = Math.round(d *10000d)/10000d;



                TextView texDist1 = (TextView)findViewById(R.id.dist1);
                String distance = Float.toString((float) d);
                texDist1.setText(distance + " m");


                Log.d("log1", distance + "   " + "varlog1: " + varLong1 + "  varlat1: " + φ1 + "  varlog2: " + varLong2 + "  varlat2: " + φ2);
               Log.d("log1","  d: "+d +"  x1000:  "+ (d*1000));

                

            }
        });

        ///Button3 Listener////////

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                varLong3 = currentLong;
                varLat3 = currentLat;
                TextView longitude = (TextView) findViewById(R.id.fixLong3);
                TextView latitude = (TextView) findViewById(R.id.fixLat3);

                String stringLong = Double.toString(varLong3);
                String stringLat = Double.toString(varLat3);

                assert longitude != null;
                longitude.setText(stringLong);
                assert latitude != null;
                latitude.setText(stringLat);


                button3.setTextColor(Color.RED);
                button4.setVisibility(view.VISIBLE);
                TextView long3 = (TextView) findViewById(R.id.textLong3);
                TextView lat3 = (TextView) findViewById(R.id.textLat3);
                long3.setVisibility(view.VISIBLE);
                lat3.setVisibility(view.VISIBLE);

                //calculate dist between 2_3///

                double r = 6371000; // metres
                double φ1 = Math.toRadians(varLat2);
                double φ2 = Math.toRadians(varLat3);
                double Δφ = Math.toRadians(varLat3-varLat2);
                double Δλ = Math.toRadians(varLong3-varLong2);

                double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
                        Math.cos(φ1) * Math.cos(φ2) *
                                Math.sin(Δλ/2) * Math.sin(Δλ/2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

                double  d = r * c;
                d = Math.round(d *10000d)/10000d;



                TextView texDist2 = (TextView)findViewById(R.id.dist2);
                String distance = Float.toString((float) d);
                texDist2.setText(distance + " m");

            }
        });

        ///Button4 Listener////////

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                varLong4 = currentLong;
                varLat4 = currentLat;
                TextView longitude = (TextView) findViewById(R.id.fixLong4);
                TextView latitude = (TextView) findViewById(R.id.fixLat4);

                String stringLong = Double.toString(varLong4);
                String stringLat = Double.toString(varLat4);

                assert longitude != null;
                longitude.setText(stringLong);
                assert latitude != null;
                latitude.setText(stringLat);


                button4.setTextColor(Color.RED);
                button5.setVisibility(view.VISIBLE);
                TextView long4 = (TextView) findViewById(R.id.textLong4);
                TextView lat4 = (TextView) findViewById(R.id.textLat4);
                long4.setVisibility(view.VISIBLE);
                lat4.setVisibility(view.VISIBLE);

                //calculate dist between 3_4///

                double r = 6371000; // metres
                double φ1 = Math.toRadians(varLat3);
                double φ2 = Math.toRadians(varLat4);
                double Δφ = Math.toRadians(varLat4-varLat3);
                double Δλ = Math.toRadians(varLong4-varLong3);

                double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
                        Math.cos(φ1) * Math.cos(φ2) *
                                Math.sin(Δλ/2) * Math.sin(Δλ/2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

                double  d = r * c;
                d = Math.round(d *10000d)/10000d;



                TextView texDist3 = (TextView)findViewById(R.id.dist3);
                String distance = Float.toString((float) d);
                texDist3.setText(distance + " m");

            }
        });

        ///Button5 Listener////////

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                varLong5 = currentLong;
                varLat5 = currentLat;
                TextView longitude = (TextView) findViewById(R.id.fixLong5);
                TextView latitude = (TextView) findViewById(R.id.fixLat5);

                String stringLong = Double.toString(varLong5);
                String stringLat = Double.toString(varLat5);

                assert longitude != null;
                longitude.setText(stringLong);
                assert latitude != null;
                latitude.setText(stringLat);


                button5.setTextColor(Color.RED);
                //button6.setVisibility(view.VISIBLE);
                TextView long5 = (TextView) findViewById(R.id.textLong5);
                TextView lat5 = (TextView) findViewById(R.id.textLat5);
                long5.setVisibility(view.VISIBLE);
                lat5.setVisibility(view.VISIBLE);

                //calculate dist between 3_4///

                double r = 6371000; // metres
                double φ1 = Math.toRadians(varLat4);
                double φ2 = Math.toRadians(varLat5);
                double Δφ = Math.toRadians(varLat5-varLat4);
                double Δλ = Math.toRadians(varLong5-varLong4);

                double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
                        Math.cos(φ1) * Math.cos(φ2) *
                                Math.sin(Δλ/2) * Math.sin(Δλ/2);
                double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

                double  d = r * c;
                d = Math.round(d *10000d)/10000d;



                TextView texDist4 = (TextView)findViewById(R.id.dist4);
                String distance = Float.toString((float) d);
                texDist4.setText(distance + " m");

            }
        });






    }






    @Override
    public void onLocationChanged(Location location) {

        currentLong = location.getLongitude();
        currentLat = location.getLatitude();

        TextView longitude = (TextView) findViewById(R.id.longCurrent);
        TextView latitude = (TextView) findViewById(R.id.latCurrent);

        //longitude.setText("LONG: "+location.getLongitude());
        //latitude.setText("LAT  : " + location.getLatitude());

        double currentLong = location.getLongitude();
        double currentLat = location.getLatitude();
        String stringLong = Double.toString(currentLong);
        String stringLat = Double.toString(currentLat);

        assert longitude != null;
        longitude.setText(stringLong);
        assert latitude != null;
        latitude.setText(stringLat);


        TextView accuracy = (TextView) findViewById(R.id.accuracy);
        float vAccuracy = location.getAccuracy();
        String txaccuracy = Float.toString(vAccuracy);
        accuracy.setText("Accuracy: "+txaccuracy);

        TextView speed = (TextView) findViewById(R.id.speed);
        float vSpeed = location.getSpeed();
        String txSpeed = Float.toString(vSpeed);
        speed.setText("Speed: "+txSpeed);

        TextView bearing =(TextView)findViewById(R.id.bearing);
        float vbearing = location.getBearing();
        String txBearing = Float.toString(vbearing);
        bearing.setText("bearing: "+ bearing);

        TextView time =(TextView)findViewById(R.id.time);
        float vTime = location.getTime();
        String txTime = Float.toString(vTime);
        time.setText("Time: "+time);


    }




    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {


    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
