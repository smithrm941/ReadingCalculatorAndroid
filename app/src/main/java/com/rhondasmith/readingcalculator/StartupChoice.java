package com.rhondasmith.readingcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartupChoice extends AppCompatActivity {

    private Button goodreadsStart;
    private Button noSearchStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_choice);

        noSearchStart = findViewById(R.id.noSearchButton);
        goodreadsStart = findViewById(R.id.goodreadsSearchButton);

        noSearchStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWithoutGoodreads();
            }
        });

        goodreadsStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWithGoodreads();
            }
        });
    }

    private void searchWithoutGoodreads () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void searchWithGoodreads () {
        // stuff using user input and goodreads API goes here
        // should take input and goodreads info and send to Main Activity
        // to populate title and page number fields there
        // maybe book cover?
    }

}
