package com.rhondasmith.readingcalculator;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText bookTitle;
    private EditText numberOfPages;
    private EditText currentPage;
    private EditText daysToFinish;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookTitle = findViewById(R.id.whatBook);
        numberOfPages = findViewById(R.id.numberOfPages);
        currentPage = findViewById(R.id.currentPage);
        daysToFinish = findViewById(R.id.daysToFinish);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = bookTitle.getText().toString();
                String bookLength = numberOfPages.getText().toString();
                String startingPage = currentPage.getText().toString();
                String numberOfDays = daysToFinish.getText().toString();

                int numberOfPages = Integer.parseInt(bookLength);
                int currentPage = Integer.parseInt(startingPage);
                int daysToFinish = Integer.parseInt(numberOfDays);

                makeCalculation(title, numberOfPages, currentPage, daysToFinish);
            }
        });
    }

    private void makeCalculation(String title, int numberOfPages, int currentPage, int daysToFinish) {
        Intent intent = new Intent(this, Calculation.class);
        intent.putExtra("title", title);
        intent.putExtra("bookLength", numberOfPages);
        intent.putExtra("startingPage", currentPage);
        intent.putExtra("numberOfDays", daysToFinish);

        startActivity(intent);
    }
}
