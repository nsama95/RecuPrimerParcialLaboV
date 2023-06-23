package com.example.recuprimerparciallabov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    public Handler handler;
    private AdapterProducto AdapterProducto;
    private static List<ProductoModel> productos = new ArrayList<ProductoModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.handler=new Handler(this);
        //"http://192.168.1.50:3000/productos"
        Thread ts= new Thread(new ConsultasHTTP("http://192.168.1.50:3000/productos",handler));
        ts.start();
      this.AdapterProducto = new AdapterProducto ( this, productos);

        RecyclerView rv = super.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(AdapterProducto);

    }
    public static List<ProductoModel> obtenerLista()
    {
        return  productos;
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
       /* List<ProductoModel> p = (List<ProductoModel>) message.obj;
        this.productos = p;
*/
        /*this.AdapterProducto = new AdapterProducto (this, productos);
        RecyclerView rv = super.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(AdapterProducto);*/



        AdapterProducto.productos=(List<ProductoModel>)message.obj;
        AdapterProducto.notifyDataSetChanged();

        return false;
    }

}