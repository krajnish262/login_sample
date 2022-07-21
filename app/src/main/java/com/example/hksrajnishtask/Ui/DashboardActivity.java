package com.example.hksrajnishtask.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hksrajnishtask.R;
import com.example.hksrajnishtask.adapter.SortingAdapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SortingAdapter sortingAdapter;
    ArrayList<String> MidList;
    ArrayList<String> TidList;
    ArrayList<String> AmountList;
    ArrayList<String> NarrationList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        recyclerView = findViewById(R.id.recycle_view);
        MidList = new ArrayList<>();
        TidList = new ArrayList<>();
        AmountList = new ArrayList<>();
        NarrationList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        addItemsFromJSON();

    }

    private void addItemsFromJSON() {
        try {
            JSONObject object = new JSONObject(loadJasonFromAsset());
            JSONArray sortArray = object.getJSONArray("sort");
            for (int i = 0; i < sortArray.length(); i++) {
                JSONObject sortObject = sortArray.getJSONObject(i);
                MidList.add(sortObject.getString("Mid"));
                TidList.add(sortObject.getString("Tid"));
                AmountList.add(sortObject.getString("amount"));
                NarrationList.add(sortObject.getString("narration"));


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        sortingAdapter = new SortingAdapter(MidList, TidList, AmountList, NarrationList, DashboardActivity.this);
        recyclerView.setAdapter(sortingAdapter);

    }

    private String loadJasonFromAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("sortingFile.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }


}
