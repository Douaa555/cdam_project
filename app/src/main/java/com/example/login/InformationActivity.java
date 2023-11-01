package com.example.login;

import android.widget.EditText;

import java.io.Serializable;

public class InformationActivity implements Serializable {
    public String prenom;
    public String nom;
    public String email;
    public String phone;
    public String emaill;
    public String phoneSpinner;

    public InformationActivity(String prenom, String nom, String email, String phone, String phoneSpinner) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.phone = phone;
        this.phoneSpinner = phoneSpinner;
    }

    public InformationActivity(String emaill){
        this.emaill = emaill;
    }

    public String getPrenom(){
        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setphone(String phone){
        this.phone = phone;
    }
}
