package com.example.recuprimerparciallabov.recycleView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuprimerparciallabov.MainActivity;
import com.example.recuprimerparciallabov.R;
import com.example.recuprimerparciallabov.ProductoModel;
import com.example.recuprimerparciallabov.onItemClick;

import java.util.List;

public class AdapterProducto extends RecyclerView.Adapter<ProductoViewHolder> {


   public List<ProductoModel> productos;
    private Handler handler;
    private MainActivity mainAct;
    onItemClick listener;


    public AdapterProducto( List<ProductoModel> productos,onItemClick listener){
       // this.mainAct = activity;
        this.productos = productos;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ProductoViewHolder( v,listener);

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
