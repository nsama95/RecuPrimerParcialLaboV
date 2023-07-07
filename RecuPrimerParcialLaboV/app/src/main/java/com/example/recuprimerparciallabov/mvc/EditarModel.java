package com.example.recuprimerparciallabov.mvc;

import android.app.Activity;

import com.example.recuprimerparciallabov.ProductoModel;

public class EditarModel {
    private Activity a;
    private static Integer index;
    private static ProductoModel prodEditado;

    public EditarModel(Activity a) {
        this.a = a;
    }

    public static ProductoModel getProdEditado() {
        return prodEditado;
    }

    public static void setProdEditado(ProductoModel prodEditado1) {
        EditarModel.prodEditado = prodEditado1;
    }

    public static int getIndex() {
        return index.intValue();
    }

    public static void setIndex(Integer index) {
        EditarModel.index = index;
    }

}
