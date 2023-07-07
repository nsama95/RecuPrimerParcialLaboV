package com.example.recuprimerparciallabov.mvc;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.example.recuprimerparciallabov.EditarActivity;

public class EditarController implements View.OnClickListener {
    private EditarView editarView;
    private EditarModel editarModel;
    private Activity activity;

    public EditarController(EditarModel editarModel, Activity a) {
        this.editarModel = editarModel;
        this.activity = a;
    }
    public void setView(EditarView prodView) {
        this.editarView = prodView;
    }
    @Override
    public void onClick(View view) {
        this.editarView.guardar();
        activity.finish();
    }
}
