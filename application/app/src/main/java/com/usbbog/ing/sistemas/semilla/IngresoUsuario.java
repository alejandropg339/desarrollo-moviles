package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        //Ejecuta el metodo acerca_app
        if (id==R.id.login){
            cerrarSesion();
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

    public void cerrarSesion(){
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

    public void logOut(View view){
        Intent ir1 = new Intent(this, Login.class);
        startActivity(ir1);
    }

    public void alertOneButton(){
        new AlertDialog.Builder(IngresoUsuario.this).setTitle("Cerrar app").setMessage("Esta seguro que desea cerra la aplicación?")
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