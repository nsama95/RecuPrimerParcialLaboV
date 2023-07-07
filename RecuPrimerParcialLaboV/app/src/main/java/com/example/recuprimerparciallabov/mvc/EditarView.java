package com.example.recuprimerparciallabov.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.recuprimerparciallabov.ProductoModel;
import com.example.recuprimerparciallabov.R;

public class EditarView {

    Activity editarActivity;
    ProductoModel modelo;
    private EditarModel editarModel;
    private EditarController editarController;
    EditText nombre;
    EditText cantidad;
    EditText precio;

    public EditarView(Activity activity, EditarModel moldeModel, EditarController moldeController, Bundle extras){
        this.editarActivity =activity;
        this.editarModel = moldeModel;
        this.editarController = moldeController;

        Button btnEditar = activity.findViewById(R.id.btnEditar);
        this.nombre = activity.findViewById(R.id.inputName);
        this.cantidad = activity.findViewById(R.id.inputCantidad);
        this.precio =  activity.findViewById(R.id.inputPrecio);

        btnEditar.setOnClickListener(this.editarController);

        nombre.setText(extras.getString("nombre"));
        cantidad.setText(extras.getString("cantidad"));
        precio.setText(extras.getString("precio"));

       this.editarModel.setIndex(Integer.valueOf(extras.getInt("position")));
    }

    public void guardar(){

        try {

            String nameP = this.nombre.getText().toString();
            Integer precioP = Integer.parseInt(precio.getText().toString());
            Integer cantidadP = Integer.parseInt(cantidad.getText().toString());

            this.editarModel.setProdEditado(new ProductoModel(nameP, cantidadP, precioP));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        /*modelo.setNombre(nombre.getText().toString());
        modelo.setPrecio(Integer.parseInt(precio.getText().toString()));
        modelo.setCantidad(Integer.parseInt(cantidad.getText().toString()));*/

    }

}
