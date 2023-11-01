package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    public ListView listView;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_show);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        InformationActivity info = (InformationActivity) bundle.getSerializable("obj");
        ArrayList<String> infoList = new ArrayList<>();
        listView = findViewById(R.id.list_item);
        if(info.getNom()==null){
        infoList.add("Email: " + info.emaill);
        }else{
        infoList.add("First Name: " + info.getPrenom());
        infoList.add("Last Name: " + info.getNom());
        infoList.add("Email: " + info.getEmail());
        infoList.add("Phone: " + info.phoneSpinner + " "+info.getPhone());
    }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, infoList);
        listView.setAdapter(adapter);
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
    }
}
