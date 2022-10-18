package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

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
    UniversidadFragment universidadFragment = new UniversidadFragment();
    Button btnMostrar;
    EditText idPais, idNombre;
    String strPais = "", strNombre = "";
    ScrollView idLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMostrar = findViewById(R.id.btnMostrar);
        idNombre = findViewById(R.id.idNombre);
        idPais = findViewById(R.id.idPais);

        idLista = findViewById(R.id.idLista);
        idLista.setVisibility(View.INVISIBLE);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strPais = String.valueOf(idPais.getText());
                strNombre = String.valueOf(idNombre.getText());

                Bundle bundle = new Bundle();
                bundle.putString("DataNombreUni", strNombre);
                bundle.putString("DataPais", strPais);
                universidadFragment.setArguments(bundle);

                getSupportFragmentManager()
                        .beginTransaction()
                        .detach(universidadFragment)
                        .commit();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragmentContainerView2,universidadFragment)
                        .commit();
                idLista.setVisibility(View.VISIBLE);
            }
        });
    }
}