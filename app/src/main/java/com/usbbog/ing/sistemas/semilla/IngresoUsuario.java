package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IngresoUsuario extends AppCompatActivity {

    Button inventario, reportes, datosPersonales;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_usuario);
        String titulo  = getIntent().getStringExtra("user");
        this.setTitle(titulo);

        inventario = (Button) findViewById(R.id.inventario);
        reportes= (Button) findViewById(R.id.reportes);
        datosPersonales = (Button) findViewById(R.id.datosPersonales);

        user = getIntent().getStringExtra("username");
        pass = getIntent().getStringExtra("contrasena");


    }

    public void inventariFinal(View view) {
        Intent a1 = new Intent(this, Inventario.class);
        startActivity(a1);

    }

    public void reportesFinal(View view) {
        Intent a1 = new Intent(this, Reportes.class);
        startActivity(a1);

    }

    public void datosPersonalesFinal(View view) {
        Intent a1 = new Intent(this, CambiarContrasena.class);
        a1.putExtra("user",user);
        a1.putExtra("pass",pass);
        startActivity(a1);
    }
}