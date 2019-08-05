package com.rhondasmith.readingcalculator;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Calculation extends AppCompatActivity {

    public static final String TAG = Calculation.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        TextView bookTitleView = findViewById(R.id.calcLineTwo);
        TextView daysToFinishView = findViewById(R.id.calcLineThree);
        TextView pagesPerDayView = findViewById(R.id.calcLineFive);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        int numberOfPages = intent.getIntExtra("bookLength", 0);
        int currentPage = intent.getIntExtra("startingPage", 0);
        int daysToFinish = intent.getIntExtra("numberOfDays", 0);

        Log.d(TAG, title);

        if(title.equals("")) {
            bookTitleView.setText(R.string.DefaultBookTitle);
        } else {
            bookTitleView.setText(title);
        }

        daysToFinishView.setText(getResources().getString(R.string.CalcLineThree, daysToFinish));

        int pagesPerDay = (numberOfPages - currentPage) / daysToFinish;
        pagesPerDayView.setText(getResources().getString(R.string.CalcLineFive, pagesPerDay));
    }
}
