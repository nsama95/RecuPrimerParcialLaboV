package com.example.recuprimerparciallabov;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.Objects;

public class ProductoModel {
    private String nombre;
    private int cantidad;
    private int precio;
    private int id;

    public ProductoModel(String nombre, int cantidad, int precio,int id) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id=id;
    }
    public ProductoModel() {}
    public int getId() {
        return this.id;
    }
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoModel)) return false;
        ProductoModel producto = (ProductoModel) o;
        return Objects.equals(getNombre(), producto.getNombre()) &&
                Objects.equals(getCantidad(), producto.getCantidad()) &&
                Objects.equals(getPrecio(), producto.getPrecio());
    }
    @NonNull
    @Override
    public String toString()
    {

        String objString =
                " Nombre: "+this.nombre+
                        "Altura: "+this.cantidad+
                        "masa: "+this.precio;

        return objString;
    }

}
