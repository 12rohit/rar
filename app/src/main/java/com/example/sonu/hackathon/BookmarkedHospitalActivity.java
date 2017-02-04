package com.example.sonu.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class BookmarkedHospitalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarked_hospital);

        /*recyclerView= (RecyclerView) findViewById(R.id.bookmarked_recycler_view);

        BookmarkedRecyclerAdapter adapter=new BookmarkedRecyclerAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        //Layout manager for Recycler view

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    */}
}
