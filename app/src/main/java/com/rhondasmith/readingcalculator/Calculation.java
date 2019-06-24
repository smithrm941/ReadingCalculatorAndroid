package com.rhondasmith.readingcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Calculation extends AppCompatActivity {

    public static final String TAG = Calculation.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        int numberOfPages = intent.getIntExtra("bookLength", 0);
        int currentPage = intent.getIntExtra("startingPage", 0);
        int daysToFinish = intent.getIntExtra("numberOfDays", 0);

        Log.d(TAG, title);
        Log.d(TAG, "number of pages: " + numberOfPages);
        Log.d(TAG, "current page: " + currentPage);
        Log.d(TAG, "days to finish: " + daysToFinish);
    }
}
