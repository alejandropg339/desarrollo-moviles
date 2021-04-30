package com.usbbog.ing.sistemas.semilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Inventario extends AppCompatActivity {

    ListView list, list2;
    ArrayList<String> milista = new ArrayList<String>();
    ArrayList<String> milista2 = new ArrayList<String>();
    Button search;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        list = (ListView) findViewById(R.id.mi_lista);
        list2 = (ListView) findViewById(R.id.mi_lista2);
        search = (Button) findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryProducts("http://192.168.0.2/desarrollo-moviles/server/query-product.php");
            }
        });
    }

    public void volver(View view){
        Intent a1 = new Intent(this, Ingreso.class);
        startActivity(a1);
    }

    private void queryProducts(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);



                        String id = jsonObject.getString("id");
                        String nombre = jsonObject.getString("nombre");
                        String tamano = jsonObject.getString("tamano");
                        String descripcion = jsonObject.getString("descripcion");
                        String costo = jsonObject.getString("costo");
                        String precio =jsonObject.getString("precio");

                        //link[i]=nombre;
                        //link[0]=nombre;
                        //email.setText(nombre);
                        milista.add(i,nombre);
                        milista2.add(i,tamano);
                        actualizar();

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

    public void actualizar(){
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.list_item_pro, milista);
        list.setAdapter(adapter);

        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this, R.layout.list_item_pro2, milista2);
        list2.setAdapter(adapter2);
    }
}