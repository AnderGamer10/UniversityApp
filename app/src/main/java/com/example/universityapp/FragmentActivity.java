package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {
    Button btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newActivity = new Intent(FragmentActivity.this, MainActivity.class);
                FragmentActivity.this.startActivity(newActivity);
            }
        });
    }
}

//                        TODO: Para eliminar y crear el fragmento
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .detach(universidadFragment)
//                        .commit();
//
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .add(R.id.fragmentoUniversidad,universidadFragment)
//                        .commit();