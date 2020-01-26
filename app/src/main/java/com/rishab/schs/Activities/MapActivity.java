package com.rishab.schs.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.rishab.schs.R;


public class MapActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        return true;
    }
}
