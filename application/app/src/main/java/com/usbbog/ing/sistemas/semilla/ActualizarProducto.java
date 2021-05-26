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
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActualizarProducto extends AppCompatActivity {

    EditText inputName, inputDescription, inputAmount,inputCost, inputPrice, inputId;
    Button update;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_producto);

        inputId = (EditText) findViewById(R.id.inputId);
        inputName = (EditText) findViewById(R.id.inputName2);
        inputDescription = (EditText)findViewById(R.id.inputDescription2);
        inputAmount = (EditText) findViewById(R.id.inputAmount2);
        inputCost = (EditText)findViewById(R.id.inputCost2);
        inputPrice = (EditText)findViewById(R.id.inputPrice2);

        update = (Button)findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProduct("http://192.168.1.103:3000/update-product.php?id="+Integer.parseInt(inputId.getText().toString())+"&nombre="+inputName.getText().toString()+"&tamano="+inputAmount.getText().toString()+"&descripcion="+inputDescription.getText().toString()+"&costo="+Double.parseDouble(inputCost.getText().toString())+"&precio="+Double.parseDouble(inputPrice.getText().toString()));
            }
        });
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

    public void volver(View view){
        Intent a1 = new Intent(this, Ingreso.class);
        startActivity(a1);
    }

    public void updateProduct(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Algo Fallo", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString()+"El error esta aca", Toast.LENGTH_SHORT).show();
            }
        }){
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void alertOneButton(){
        new AlertDialog.Builder(ActualizarProducto.this).setTitle("Cerrar app").setMessage("Esta seguro que desea cerra la aplicación?")
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