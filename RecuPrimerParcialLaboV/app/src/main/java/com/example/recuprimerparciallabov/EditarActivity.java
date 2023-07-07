package com.example.recuprimerparciallabov;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recuprimerparciallabov.mvc.EditarController;
import com.example.recuprimerparciallabov.mvc.EditarModel;
import com.example.recuprimerparciallabov.mvc.EditarView;
import com.example.recuprimerparciallabov.recycleView.AdapterProducto;

import java.util.List;

public class EditarActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        EditarModel model = new EditarModel(this);
        EditarController controller = new EditarController(model, this);
        Bundle extras = super.getIntent().getExtras();
        EditarView view = new EditarView(this, model, controller, extras);

       controller.setView(view);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
