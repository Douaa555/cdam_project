package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView facebook;
    EditText psswd;
    TextView account;
    Button connecte;
    EditText mail;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Connectez-vous");
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        setContentView(R.layout.activity_login);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        facebook = findViewById(R.id.ffb);
        account = findViewById(R.id.compte);
        mail = findViewById(R.id.mail);
        psswd = findViewById(R.id.psswd);
        connecte = findViewById(R.id.btn1);

        account.setOnClickListener(view -> {
            Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(register);
        });

        connecte.setOnClickListener(view -> {
            String mail1 = mail.getText().toString();
            String psswd1 = psswd.getText().toString();

            if (mail1.isEmpty() || psswd1.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Les champs sont vides!", Toast.LENGTH_SHORT).show();
            } else {
                InformationActivity info = new InformationActivity(mail1);

                Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("obj", info);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        facebook.setOnClickListener(view -> {
            Uri uriUrl = Uri.parse("https://www.facebook.com/login/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
        });
    }
}
