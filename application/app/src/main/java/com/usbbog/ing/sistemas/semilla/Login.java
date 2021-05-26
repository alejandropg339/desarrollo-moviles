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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private Button log;
    EditText user, password;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       user = findViewById(R.id.user);
       password = findViewById(R.id.password);

        log = (Button) findViewById(R.id.log);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar("http://192.168.1.103:3000/querys-usuario.php?user="+user.getText().toString()+"&password="+password.getText().toString());
            }
        });

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

    private void ingresar(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            String link = "http://192.168.1.103:3000/querys-usuario.php?user="+user.getText().toString()+"&password="+password.getText().toString();
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                        ejecutarConsulta(link);
                    Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
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

    public void crearCuenta(View view){
        Intent a1 = new Intent(this, CrearCuenta.class);
        startActivity(a1);
    }

    private void ejecutarConsulta(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        if(jsonObject.getString("rol").equals("1")){
                            String nombreUsuario = jsonObject.getString("nombre");
                            String username = jsonObject.getString("username");
                            String pass = jsonObject.getString("contrasena");
                            String cedulaUsuario = jsonObject.getString("cedula");
                            String correUsuario =  jsonObject.getString("correo");
                            String telefonoUsuario = jsonObject.getString("telefono");


                            Intent cambiraUsuario = new Intent(getApplicationContext(), CambiarContrasena.class);
                            cambiraUsuario.putExtra("username", username);

                            Intent cambiarContrasena = new Intent(getApplicationContext(),CambiarContrasena.class);
                            cambiarContrasena.putExtra("contrasena", pass);

                            Intent infoNombre = new Intent(getApplicationContext(), CambiarContrasena.class);
                            cambiraUsuario.putExtra("nombre", nombreUsuario);

                            Intent infoCedula = new Intent(getApplicationContext(),CambiarContrasena.class);
                            cambiarContrasena.putExtra("cedula", cedulaUsuario);

                            Intent infoCorreo = new Intent(getApplicationContext(), CambiarContrasena.class);
                            cambiraUsuario.putExtra("correo", correUsuario);

                            Intent infoTelefono = new Intent(getApplicationContext(),CambiarContrasena.class);
                            cambiarContrasena.putExtra("telefono", telefonoUsuario);

                            Intent a1 = new Intent(getApplicationContext(), Ingreso.class);
                            a1.putExtra("user","Bienvenido "+nombreUsuario);
                            startActivity(a1);
                        }else if(jsonObject.getString("rol").equals("2")){
                            String nombreUsuario = jsonObject.getString("nombre");
                            String username = jsonObject.getString("username");
                            String pass = jsonObject.getString("contrasena");
                            String cedulaUsuario = jsonObject.getString("cedula");
                            String correUsuario =  jsonObject.getString("correo");
                            String telefonoUsuario = jsonObject.getString("telefono");

                            Intent cambiraUsuario = new Intent(getApplicationContext(), CambiarContrasena.class);
                            cambiraUsuario.putExtra("username", username);

                            Intent cambiarContrasena = new Intent(getApplicationContext(),CambiarContrasena.class);
                            cambiarContrasena.putExtra("contrasena", pass);

                            Intent infoNombre = new Intent(getApplicationContext(), CambiarContrasena.class);
                            cambiraUsuario.putExtra("nombre", nombreUsuario);

                            Intent infoCedula = new Intent(getApplicationContext(),CambiarContrasena.class);
                            cambiarContrasena.putExtra("cedula", cedulaUsuario);

                            Intent infoCorreo = new Intent(getApplicationContext(), CambiarContrasena.class);
                            cambiraUsuario.putExtra("correo", correUsuario);

                            Intent infoTelefono = new Intent(getApplicationContext(),CambiarContrasena.class);
                            cambiarContrasena.putExtra("telefono", telefonoUsuario);


                            Intent a2 = new Intent(getApplicationContext(), IngresoUsuario.class);
                            a2.putExtra("user","Bienvenido "+nombreUsuario);
                            a2.putExtra("username", username);
                            a2.putExtra("contrasena", pass);
                            startActivity(a2);
                        }
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error de conexion",Toast.LENGTH_SHORT).show();
            }
        }
        );

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    public void alertOneButton(){
        new AlertDialog.Builder(Login.this).setTitle("Cerrar app").setMessage("Esta seguro que desea cerra la aplicación?")
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