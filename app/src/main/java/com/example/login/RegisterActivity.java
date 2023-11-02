package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText Prenom;
    private EditText Nom;
    private EditText Email;
    private EditText Phone;
    private EditText Mdps;
    private Spinner phoneSpinner;
    private Button btnSubmit;

    private TextView prenom_err;
    private TextView nom_err;
    private TextView phone_err;
    private TextView mdps_err;
    private TextView email_err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Nom = findViewById(R.id.nom);
        Prenom = findViewById(R.id.prenom);
        Email = findViewById(R.id.email);
        Phone = findViewById(R.id.phone);
        Mdps = findViewById(R.id.mdps);
        phoneSpinner = findViewById(R.id.phoneSpinner);
        btnSubmit = findViewById(R.id.btn);

        phone_err = findViewById(R.id.phone_err);
        mdps_err = findViewById(R.id.mdps_err);
        email_err = findViewById(R.id.email_err);
        prenom_err = findViewById(R.id.prenom_err);
        nom_err = findViewById(R.id.nom_err);


        String[] phoneOptions = {"+231", "+1", "+44", "+61", "+81"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, phoneOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneSpinner.setAdapter(adapter);

        btnSubmit.setOnClickListener(view -> {

            String prenomText = Prenom.getText().toString();
            String nomText = Nom.getText().toString();
            String emailText = Email.getText().toString();
            String phoneText = Phone.getText().toString();
            String mdpsText = Mdps.getText().toString();
            String spinnerText = phoneSpinner.getSelectedItem().toString();

            String passwd_pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_-])(?=\\S+$).{8,20}$";
            String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-z]+";

            if (prenomText.isEmpty() || nomText.isEmpty() || emailText.isEmpty() || phoneText.isEmpty() || mdpsText.isEmpty()) {

                if (prenomText.isEmpty()) {
                    prenom_err.setText("* Field required!");
                } else {
                    prenom_err.setText("");
                }

                if (nomText.isEmpty()) {
                    nom_err.setText("* Field required!");
                } else {
                    nom_err.setText("");
                }

                if (emailText.isEmpty()) {
                    email_err.setText("* Field required!");
                } else {
                    email_err.setText("");
                }

                if (mdpsText.isEmpty()) {
                    mdps_err.setText("* Field required!");
                } else {
                    mdps_err.setText("");
                }

                if (phoneText.isEmpty()) {
                    phone_err.setText("* Field required!");
                } else {
                    phone_err.setText("");
                }

            } else if (emailText.matches(emailPattern) && mdpsText.matches(passwd_pattern) && phoneText.length() >= 10) {
                InformationActivity info = new InformationActivity(prenomText, nomText, emailText, phoneText, spinnerText);
                Intent intent = new Intent(getApplicationContext(), ShowActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("obj", info);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                if (!emailText.matches(emailPattern)) {
                    email_err.setText("*Format incorrecte:xxxx@xxx.xx");
                } else {
                    email_err.setText("");
                }
                if (!mdpsText.matches(passwd_pattern)) {
                    mdps_err.setText("*Mot de passe faible");
                } else {
                    mdps_err.setText("");
                }
                if (phoneText.length() < 10) {
                    phone_err.setText("*Numéro érroné");
                } else {
                    phone_err.setText("");
                }
            }
        });
    }
}
