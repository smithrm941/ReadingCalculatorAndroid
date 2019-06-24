package com.rhondasmith.readingcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

        // This needs a default if no title is entered:
        bookTitleView.setText(title);

        // Want this to be part of current text "within [goal days] days"
        daysToFinishView.setText(String.format(Locale.getDefault(), "%d", daysToFinish));

        // This value will be calculated based on daysToFinish, numberOfPages and currentPage
        // and be part of original text "[pages] pages per day!"
        pagesPerDayView.setText("[calculated number] pages per day!");
    }
}
