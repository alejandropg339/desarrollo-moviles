package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Ingreso extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        String titulo  = getIntent().getStringExtra("user");
        this.setTitle(titulo);

    }

    public void registrar(View view){
        Intent ir1 = new Intent(this, RegistrarProducto.class);
        Toast toast1 = Toast.makeText(getApplicationContext(), "RegistarProducto", Toast.LENGTH_SHORT);
        toast1.show();
        startActivity(ir1);
    }

    public void eliminar(View view){
        Intent ir1 = new Intent(this, EliminarProducto.class);
        Toast toast1 = Toast.makeText(getApplicationContext(), "EliminarProducto", Toast.LENGTH_SHORT);
        toast1.show();
        startActivity(ir1);
    }

    public void actualizar(View view){
        Intent ir1 = new Intent(this, ActualizarProducto.class);
        Toast toast1 = Toast.makeText(getApplicationContext(), "ActualizarProducto", Toast.LENGTH_SHORT);
        toast1.show();
        startActivity(ir1);
    }

    public void inventario(View view){
        Intent ir1 = new Intent(this, Inventario.class);
        Toast toast1 = Toast.makeText(getApplicationContext(), "Inventario", Toast.LENGTH_SHORT);
        toast1.show();
        startActivity(ir1);
    }

    public void reportes(View view){
        Intent ir1 = new Intent(this, Reportes.class);
        Toast toast1 = Toast.makeText(getApplicationContext(), "Reportes", Toast.LENGTH_SHORT);
        toast1.show();
        startActivity(ir1);
    }

    public void logOut(View view){
        Intent ir1 = new Intent(this, Login.class);
        startActivity(ir1);
    }

}