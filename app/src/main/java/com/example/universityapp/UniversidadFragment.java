package com.example.universityapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.universityapp.placeholder.PlaceholderContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class UniversidadFragment extends Fragment {
    String strPais = "", strNombreUni = "";
    ArrayList<Universidad> datosUniversidades;


    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    public UniversidadFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static UniversidadFragment newInstance(int columnCount) {
        UniversidadFragment fragment = new UniversidadFragment();
        Bundle args = new Bundle();

        args.putInt(ARG_COLUMN_COUNT, columnCount);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            strNombreUni = getArguments().getString("DataNombreUni");
            strPais = getArguments().getString("DataPais");

            datosUniversidades = new ArrayList<>();
            LeerApi();
        }catch (Exception e){
            e.getMessage();
        }


        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_universidades_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyUniversidadRecyclerViewAdapter(datosUniversidades));
        }
        return view;
    }



//    TODO: Hacer la llamada de la API en el fragmento
    private void LeerApi() {
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
//                    TODO: Para pruebas de datos guardados  ------ Borrar en el futuro ------
//                    for (Universidad nombreUni: datosUniversidades){
//                        Log.i("cositas2", nombreUni.nombre + " " + nombreUni.domain);
//                    }

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
        Volley.newRequestQueue(getContext()).add(postResquest);
    }





}