package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private TextView facebook;
    private EditText psswd;
    private TextView account;
    private Button connecte;
    private EditText mail;
    private TextView email_err;
    private TextView mdps_err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Connectez-vous");
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        facebook = findViewById(R.id.ffb);
        account = findViewById(R.id.compte);
        mail = findViewById(R.id.mail);
        psswd = findViewById(R.id.psswd);
        connecte = findViewById(R.id.btn1);
        email_err = findViewById(R.id.email_err);
        mdps_err = findViewById(R.id.mdps_err);

        account.setOnClickListener(view -> {
            Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(register);
        });

        connecte.setOnClickListener(view -> {
            String mailText = mail.getText().toString();
            String psswdText = psswd.getText().toString();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-z]+";

            if (mailText.isEmpty() || psswdText.isEmpty()) {

                if (mailText.isEmpty()) {
                    email_err.setText("* Champ vide!");
                } else {
                    email_err.setText("");
                }

                if (psswdText.isEmpty()) {
                    mdps_err.setText("* Champ vide!");
                } else {
                    mdps_err.setText("");
                }

            } else if (mailText.matches(emailPattern)) {
                InformationActivity info = new InformationActivity(mailText);
                Intent intent = new Intent(LoginActivity.this, ShowActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("obj", info);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                if (!mailText.matches(emailPattern)) {
                    email_err.setText("*Format incorrecte:xxxx@xxx.xx");
                } else {
                    email_err.setText("");
                }
            }
        });

        facebook.setOnClickListener(view -> {
            Uri uriUrl = Uri.parse("https://www.facebook.com/login/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
        });
    }
}