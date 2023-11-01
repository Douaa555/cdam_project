package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText Prenom;
    private EditText Nom;
    private EditText Email;
    private EditText Phone;
    private EditText Mdps;
    private Spinner phoneSpinner;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Nom = findViewById(R.id.nom);
        Prenom = findViewById(R.id.prenom);
        Email = findViewById(R.id.email);
        Phone = findViewById(R.id.phone);
        Mdps = findViewById(R.id.mdps);
        phoneSpinner = findViewById(R.id.phoneSpinner);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Spinner phoneSpinner = findViewById(R.id.phoneSpinner);
        String[] phoneOptions = {"+231", "+1", "+44", "+61", "+81"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, phoneOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phoneSpinner.setAdapter(adapter);

        Button btnSubmit = findViewById(R.id.btn);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prenomText = Prenom.getText().toString();
                String nomText = Nom.getText().toString();
                String emailText = Email.getText().toString();
                String phoneText = Phone.getText().toString();
                String mdpsText = Mdps.getText().toString();
                String phoneSpinner1 = phoneSpinner.getSelectedItem().toString();

                if (prenomText.isEmpty() || nomText.isEmpty() || emailText.isEmpty() || phoneText.isEmpty() || mdpsText.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Les champs sont vides!", Toast.LENGTH_SHORT).show();
                } else {
                    InformationActivity info = new InformationActivity(prenomText, nomText, emailText, phoneText, phoneSpinner1);
                    Intent intent = new Intent(getApplicationContext(), ShowActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("obj", info);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}
