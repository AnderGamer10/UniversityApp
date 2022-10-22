package com.example.universityapp;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.universityapp.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.universityapp.databinding.FragmentUniversidadBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyUniversidadRecyclerViewAdapter extends RecyclerView.Adapter<MyUniversidadRecyclerViewAdapter.ViewHolder> {

    private final List<Universidad> mValues;

    public MyUniversidadRecyclerViewAdapter(List<Universidad> items) {
        this.mValues = items;
    }
    Context context;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();

        return new ViewHolder(FragmentUniversidadBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        int thisUni = position;
        holder.itemUni = mValues.get(position);
        holder.txtNombreUnis.setText(mValues.get(position).nombre);
        holder.btnMostrarWeb.setText("Ver");
        holder.btnMostrarWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(context, WebViewActivity.class);
                newIntent.putExtra("url-web", mValues.get(thisUni).domain);
                context.startActivity(newIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtNombreUnis;
        public final Button btnMostrarWeb;
        public Universidad itemUni;

        public ViewHolder(FragmentUniversidadBinding binding) {
            super(binding.getRoot());
            txtNombreUnis = binding.nombreUniversidad;
            btnMostrarWeb = binding.btnVer;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + btnMostrarWeb.getText() + "'";
        }


    }
}

