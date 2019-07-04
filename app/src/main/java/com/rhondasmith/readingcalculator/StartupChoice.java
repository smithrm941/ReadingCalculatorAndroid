package com.rhondasmith.readingcalculator;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

public class StartupChoice extends AppCompatActivity {

    private Button noSearchStart;
    private SearchView goodreadsSearchBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_choice);

        goodreadsSearchBox = findViewById(R.id.searchBox);


        goodreadsSearchBox.setSubmitButtonEnabled(true);


        goodreadsSearchBox.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getBaseContext(), query, Toast.LENGTH_LONG).show();
                doMySearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getBaseContext(), newText, Toast.LENGTH_LONG).show();
                return false;
            }
        });


        noSearchStart = findViewById(R.id.noSearchButton);

        noSearchStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWithoutGoodreads();
            }
        });

    }

    private void startWithoutGoodreads () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void doMySearch(String query) {
        Log.d("I searched for: ", query);
        // Get search results from Goodreads here?
    }

}

