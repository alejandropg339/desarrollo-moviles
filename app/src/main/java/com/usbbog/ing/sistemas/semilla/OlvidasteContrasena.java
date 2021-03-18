package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OlvidasteContrasena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidaste_contrasena);
    }

    public void volver(View view){
        Intent a1 = new Intent(this, Login.class);
        startActivity(a1);
    }
}