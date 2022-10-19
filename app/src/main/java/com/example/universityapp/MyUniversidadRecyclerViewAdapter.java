package com.example.universityapp;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentUniversidadBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).nombre);
        holder.mContentView.setText("Ver");
    }

    @Override
    public int getItemCount() {
        if (mValues == null){
            return 0;
        }
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Universidad mItem;

        public ViewHolder(FragmentUniversidadBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

    }
}

