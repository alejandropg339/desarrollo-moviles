package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class OlvidasteContrasena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidaste_contrasena);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        //Ejecuta el metodo acerca_app
        if (id==R.id.login){
            volver();
            return true;
        }
        //Ejecuta el metodo salir_app
        if (id==R.id.crearCuenta){
            irCrearCuenta();
            return true;
        }
        //Selección de la opción
        return super.onOptionsItemSelected(item);
    }

    public void volver(){
        Intent a1 = new Intent(this, Login.class);
        startActivity(a1);
    }

    public void irCrearCuenta(){
        Intent a1 = new Intent(this, CrearCuenta.class);
        startActivity(a1);
    }
}