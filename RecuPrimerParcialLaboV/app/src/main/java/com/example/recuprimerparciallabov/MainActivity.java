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

import com.example.recuprimerparciallabov.http.ConsultasHTTP;
import com.example.recuprimerparciallabov.mvc.EditarModel;
import com.example.recuprimerparciallabov.recycleView.AdapterProducto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements onItemClick, Handler.Callback {
    public Handler handler;
    private com.example.recuprimerparciallabov.recycleView.AdapterProducto AdapterProducto;
    private static List<ProductoModel> productos = new ArrayList<ProductoModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.handler=new Handler(this);
        //"http://192.168.1.50:3000/productos"
        Thread ts= new Thread(new ConsultasHTTP("http://192.168.1.50:3000/productos",handler));
        ts.start();
     /* this.AdapterProducto = new AdapterProducto (productos,this);

        RecyclerView rv = super.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(AdapterProducto);*/

    }

    @Override
    public void onIttemClick(int position) {

        Intent intent = new Intent(this, EditarActivity.class);
        ProductoModel prod = this.productos.get(position);
        intent.putExtra("position", position);
        intent.putExtra("name", prod.getNombre());
        intent.putExtra("count", prod.getCantidad());
        intent.putExtra("price", prod.getPrecio());


        startActivity(intent);
    }
    @Override
    public boolean handleMessage(@NonNull Message message) {
       List<ProductoModel> p = (List<ProductoModel>) message.obj;
        this.productos = p;
        this.AdapterProducto = new AdapterProducto (productos,this);
        RecyclerView rv = super.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(AdapterProducto);
        AdapterProducto.productos=(List<ProductoModel>)message.obj;
        AdapterProducto.notifyDataSetChanged();

        return false;
    }
      @Override
  protected void onRestart() {
        ProductoModel prodEditado =  EditarModel.getProdEditado();
        int indexEditado;

        if(prodEditado != null){
            indexEditado = EditarModel.getIndex();
            ProductoModel prodEditar = this.productos.get(indexEditado);
            prodEditar.setNombre(prodEditado.getNombre());
            prodEditar.setCantidad(prodEditado.getCantidad());
            prodEditar.setPrecio(prodEditado.getPrecio());
            AdapterProducto.notifyDataSetChanged();
            EditarModel.setProdEditado(null);
            EditarModel.setIndex(null);
        }

        super.onRestart();
    }



}