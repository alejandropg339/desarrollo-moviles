package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class CambiarContrasena extends AppCompatActivity {
    TextView dataArea;
    Button dataQuery, changePassword;
    EditText passInput;
    RequestQueue requestQueue;
    String user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasena);

        user = getIntent().getStringExtra("user");
        password = getIntent().getStringExtra("pass");
        /*cedula = getIntent().getStringExtra("cedula");
        correo = getIntent().getStringExtra("correo");
        telefono = getIntent().getStringExtra("telefono");*/

        dataArea = (TextView) findViewById(R.id.dataArea);
        passInput = (EditText) findViewById(R.id.passInput);

        dataQuery = (Button) findViewById(R.id.mi_lista);
        changePassword = (Button) findViewById(R.id.changePassword);

        dataArea.setText(user+password);

       dataQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultData("http://192.168.0.2:80/desarrollo-moviles/server/querys-usuario.php?user="+user+"&password="+password);
                Toast.makeText(getApplicationContext(), "Usuario: "+user+" Password: " +password, Toast.LENGTH_SHORT).show();
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePass("http://192.168.0.2:80/desarrollo-moviles/server/update-password.php?newPass="+passInput.getText().toString()+"&username="+user+"&password="+password);
            }
        });
    }

    private void consultData(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);

                        dataArea.setText("Nombre: "+jsonObject.getString("nombre")+"\n"+"Cedula: "+jsonObject.getString("cedula")+"\n"+"Usuario"+jsonObject.getString("username")+"\n"+"Contraseña: "+jsonObject.getString("contrasena")+"\n"+"Correo: "+jsonObject.getString("correo")+"\n"+"Telefono: "+jsonObject.getString("telefono"));

                        /*String consulta1 = jsonObject.getString("nombre");
                        String consulta2 = jsonObject.getString("dni");
                        String consulta3 =jsonObject.getString("telefono");
                        String consulta4 =jsonObject.getString("email");

                        consultas.setText("nombre: "+consulta1+" DNI: "+consulta2+" teléfono: "+consulta3+" email: "+consulta4);*/
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

    public void changePass(String URL){
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
}