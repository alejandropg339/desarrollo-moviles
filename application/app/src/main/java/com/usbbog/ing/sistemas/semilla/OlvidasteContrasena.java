package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

        if (id==R.id.creadores){
            irCreadores();
            return true;
        }

        if (id==R.id.version){
            irVersion();
            return true;
        }
        //Selección de la opción
        return super.onOptionsItemSelected(item);
    }

    public void volver(){
        Intent a1 = new Intent(this, Login.class);
        startActivity(a1);
    }

    public void cerrarSesion(View view){
        Intent a1 = new Intent(this, Login.class);
        startActivity(a1);
    }

    public void irCreadores(){
        Intent a1 = new Intent(this, Creadores.class);
        startActivity(a1);
    }

    public void irVersion(){
        Intent a1 = new Intent(this, Version.class);
        startActivity(a1);
    }

    public void alertOneButton(){
        new AlertDialog.Builder(OlvidasteContrasena.this).setTitle("Cerrar app").setMessage("Esta seguro que desea cerra la aplicación?")
                .setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id){
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                finish();
                            }
                        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }

    public void onBackPressed(){
        alertOneButton();
    }
}