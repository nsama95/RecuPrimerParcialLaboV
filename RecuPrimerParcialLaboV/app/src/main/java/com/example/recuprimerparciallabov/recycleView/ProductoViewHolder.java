package com.example.recuprimerparciallabov.recycleView;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuprimerparciallabov.MainActivity;
import com.example.recuprimerparciallabov.R;
import com.example.recuprimerparciallabov.onItemClick;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView nombre;
    public TextView cantidad;
    public TextView precio;
    private int position = 0;

    public MainActivity mainActivity;

    onItemClick listener;

    public ProductoViewHolder( @NonNull View itemView,onItemClick listener) {
        super(itemView);
        this.nombre = itemView.findViewById(R.id.nombreFijo);
        this.cantidad = itemView.findViewById(R.id.cantidad);
        this.precio = itemView.findViewById(R.id.precio);
        this.listener = listener;

        itemView.setOnClickListener(this);

    }
    public void setPosition(int position){
        this.position = position;
    }
    @Override
    public void onClick(View v) {
    listener.onIttemClick(this.position);
    }
}
