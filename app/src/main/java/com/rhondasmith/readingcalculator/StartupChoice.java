package com.rhondasmith.readingcalculator;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import org.w3c.dom.Document;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class StartupChoice extends AppCompatActivity {

    public static final String TAG = StartupChoice.class.getSimpleName();

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

        // hide this somehow:
        String apiKey = BuildConfig.ApiKey;

        final String searchURL = "https://www.goodreads.com/search/index.xml?key=" + apiKey + "&q=" + query;

        if(isNetworkAvailable()) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(searchURL)
                    .build();

            Call call = client.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e(TAG, "is anything happening here?");

                }

                @Override
                public void onResponse(Call call, Response response) /*throws Exception*/ {
                    try {

                        if(response.isSuccessful()) {
                            String xmlstring = response.body().string();

                            Log.v(TAG, "howdy" + xmlstring);

                            // use goodreadsBookInfo function here

                        } else {
                            Log.e(TAG, "Uh oh, spaghetti-O's!");
                            Log.v(TAG, searchURL);

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(TAG, "ID Exception caught: ", e);
                    }
                }
            });
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;

        if(networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        else {
            Toast.makeText(this, getString(R.string.network_unavailable_message),
                    Toast.LENGTH_LONG).show();
        }
        return isAvailable;
    }

//function that will be used on response to API query:
//    private goodreadsBookInfo(String query) throws Exception {
//
//    }

}

