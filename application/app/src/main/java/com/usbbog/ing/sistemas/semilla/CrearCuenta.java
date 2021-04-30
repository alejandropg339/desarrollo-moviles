package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

public class CrearCuenta extends AppCompatActivity {

    private Button reg;
    EditText campoNombre, campoCedula, campoCorreo, campoTelefono;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        campoNombre = findViewById(R.id.campoNombre);
        campoCedula = findViewById(R.id.campoCedula);
        campoCorreo = findViewById(R.id.campoCorreo);
        campoTelefono = findViewById(R.id.campoTelefono);

        reg = (Button) findViewById(R.id.botonRegistrarse);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar("http://192.168.0.2:80/desarrollo-moviles/server/create-user.php?nombre="+campoNombre.getText().toString()+"&cedula="+Integer.parseInt(campoCedula.getText().toString())+"&correo="+campoCorreo.getText().toString()+"&telefono="+Integer.parseInt(campoTelefono.getText().toString())+"&username="+campoCedula.getText().toString()+"&contrasena="+campoCedula.getText().toString());
            }
        });
    }

    private void ingresar(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){

                    Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Error al crear la cuenta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString()+"Error de conexión", Toast.LENGTH_SHORT).show();
            }
        }){
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}