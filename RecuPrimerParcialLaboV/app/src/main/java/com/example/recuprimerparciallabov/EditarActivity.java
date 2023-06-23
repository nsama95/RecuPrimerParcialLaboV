package com.example.recuprimerparciallabov;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EditarActivity extends AppCompatActivity implements View.OnClickListener {
    private AdapterProducto adapter;
    private List<ProductoModel> listaProductos;

    int posicionDelProducto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        listaProductos = MainActivity.obtenerLista();

        Bundle bandle=super.getIntent().getExtras();
        posicionDelProducto = bandle.getInt("posicionProducto");

        Button btnEditar = this.findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(this);


        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setTitle("Modificar");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onClick(View view) {

    }
}
