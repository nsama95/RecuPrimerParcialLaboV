package com.example.recuprimerparciallabov;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterProducto extends RecyclerView.Adapter<ProductoViewHolder> {


   List<ProductoModel> productos;
    private Handler handler;
    private MainActivity mainAct;onItemClick listener;

   /* public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }*/




    public AdapterProducto(MainActivity activity, List<ProductoModel> productos){
        this.mainAct = activity;
        this.productos = productos;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ProductoViewHolder(mainAct, v);

    }



    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        ProductoModel p=this.productos.get(position);
        holder.nombre.setText(p.getNombre());
        holder.cantidad.setText(Integer.valueOf(p.getCantidad()).toString());
        holder.precio.setText(Integer.valueOf(p.getPrecio()).toString());
        holder.setPosition(position);
    }



    @Override
    public int getItemCount() { return this.productos.size(); }
}
