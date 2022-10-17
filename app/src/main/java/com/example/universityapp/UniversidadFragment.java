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

import com.example.universityapp.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class UniversidadFragment extends Fragment {

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

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("Fragemtno-----", "ADsasdasd-*-*-*-*-*-*-*-*-*-*-**-");
        try {
            String strNombreUni = getArguments().getString("DataNombreUni");
            String strPais = getArguments().getString("DataPais");
            if (strNombreUni == null){
                Log.i("prueba", " aca");
            }else {
                Log.i("prueba2", strNombreUni);
            }

        }catch (Exception e){
            e.getMessage();
        }


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
            recyclerView.setAdapter(new MyUniversidadRecyclerViewAdapter(PlaceholderContent.ITEMS));
        }
        return view;
    }
}