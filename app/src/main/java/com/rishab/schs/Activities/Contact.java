package com.rishab.schs.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.rishab.schs.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URL;
import java.util.Objects;


public class Contact extends AppCompatActivity {

    private WebView webView;
    public static final String PATH = "contactAndroid";


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toolbar.setTitle("Contact");


        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }


        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference(PATH);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue().toString();
                webView.loadUrl(link);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        goHome();
        return true;
    }

    public void goHome() {
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent1);
    }
}
