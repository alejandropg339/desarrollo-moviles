package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class RegistrarProducto extends AppCompatActivity {

    EditText inputName, inputDescription, inputAmount,inputCost, inputPrice;
    Button register;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);

        inputName = (EditText) findViewById(R.id.inputName);
        inputDescription = (EditText)findViewById(R.id.inputDescription);
        inputAmount = (EditText) findViewById(R.id.inputAmount);
        inputCost = (EditText)findViewById(R.id.inputCost);
        inputPrice = (EditText)findViewById(R.id.inputPrice);

        register = (Button)findViewById(R.id.register);

       register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productRegister("http://192.168.0.2:80/desarrollo-moviles/server/create-product.php?nombre="+inputName.getText().toString()+"&tamano="+inputAmount.getText().toString()+"&descripcion="+inputDescription.getText().toString()+"&costo="+Double.parseDouble(inputCost.getText().toString())+"&precio="+Double.parseDouble(inputPrice.getText().toString()));
            }
        });
    }

    public void volver(View view){
        Intent a1 = new Intent(this, Ingreso.class);
        startActivity(a1);
    }

    public void productRegister(String URL){
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