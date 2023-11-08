package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        InformationActivity info = (InformationActivity) bundle.getSerializable("obj");

        ArrayList<String> infoList = new ArrayList<>();

        listView = findViewById(R.id.list_item);

        if (info.getNom() == null) {
            infoList.add("Email: " + info.getEmail());
        } else {
            infoList.add("Prenom: " + info.getPrenom());
            infoList.add("Nom: " + info.getNom());
            infoList.add("Email: " + info.getEmail());
            infoList.add("Telephone: " + info.phoneSpinner + " " + info.getPhone());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, infoList);
        listView.setAdapter(adapter);
    }
}
