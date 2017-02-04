package com.example.sonu.hackathon;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String str ="hospital";
    View nearbyButton,searchButton,bookmarkedButton;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nearbyButton = findViewById(R.id.nearby_hospital_id);
        nearbyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isInternetOn()){
                    intent = new Intent(getApplicationContext(),CheckInActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), " Connected ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No Internet - No Access", Toast.LENGTH_LONG).show();
                }
            }
        });

        bookmarkedButton = findViewById(R.id.bookmarked_hospital_id);
        bookmarkedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(),BookmarkedHospitalActivity.class);
                startActivity(intent);
            }
        });

        searchButton = findViewById(R.id.search_hospital_id);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                startActivity(intent);
            }
        });
    }
    public final boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {

            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED  ) {


            //   finish();
            return false;
        }
        return false;
    }
}