package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.IDN;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btnMostrar;
    EditText idPais, idNombre;
    String strPais = "", strNombreUni = "";
    public static ArrayList<Universidad> datosUniversidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMostrar = findViewById(R.id.btnMostrar);
        idNombre = findViewById(R.id.idNombre);
        idPais = findViewById(R.id.idPais);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeerApi();
            }
        });
    }
//    TODO: Llamada a la API al clicar en mostrar
    private void LeerApi() {
        strPais = String.valueOf(idPais.getText());
        strNombreUni = String.valueOf(idNombre.getText());
        String url = "http://universities.hipolabs.com/search?country=" + strPais + "&name=" + strNombreUni;

        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonObject = new JSONArray(response);
                    for (int i = 0; i < jsonObject.length();i++){
                        JSONObject j = jsonObject.getJSONObject(i);
                        datosUniversidades.add(new Universidad(j.getString("name"), j.getString("domains").substring(2,j.getString("domains").length()-2)));
                    }
                    Intent newActivity = new Intent(MainActivity.this, FragmentActivity.class);
                    MainActivity.this.startActivity(newActivity);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }
}