package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log = (Button) findViewById(R.id.log);


    }

    public void entrar(View view) {
        Intent a1 = new Intent(this, Ingreso.class);
        Toast toast1 = Toast.makeText(getApplicationContext(), "Ingreso", Toast.LENGTH_SHORT);
        toast1.show();
        startActivity(a1);

    }

    public void losepass(View view) {
        Intent a1 = new Intent(this, OlvidasteContrasena.class);
        startActivity(a1);
    }
}