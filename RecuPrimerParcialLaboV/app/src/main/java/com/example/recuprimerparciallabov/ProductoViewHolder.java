package com.example.recuprimerparciallabov;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView nombre;
    public TextView cantidad;
    public TextView precio;
    private int position = 0;

    public MainActivity mainActivity;

    onItemClick listener;

    public ProductoViewHolder(MainActivity mainActivity, @NonNull View itemView) {
        super(itemView);
        this.nombre = itemView.findViewById(R.id.nombreFijo);
        this.cantidad = itemView.findViewById(R.id.cantidad);
        this.precio = itemView.findViewById(R.id.precio);
        this.listener = listener;
        this.mainActivity = mainActivity;
        itemView.setOnClickListener(this);

    }
    public void setPosition(int position){
        this.position = position;
    }
    @Override
    public void onClick(View v) {
    listener.onItemClick(this.position);
    }
}
