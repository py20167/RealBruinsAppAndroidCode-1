package com.rishab.schs;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;


public class FragmentTwo extends Fragment {

    private WebView webView;
    public static final String PATH = "bellplus";

    public FragmentTwo() {
        // Required empty public constructor
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_two, container, false);
        WebView webView = (WebView) v.findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

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




return v;




    }




}

