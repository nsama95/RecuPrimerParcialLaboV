package com.example.recuprimerparciallabov;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParserJson {
    public static List<ProductoModel> parsearJSON(String str) throws JSONException {
        List<ProductoModel> proList= new ArrayList<>();
        try {
            JSONArray proArray = new JSONArray(str);

            //Log.d("hola"+perArray);
            for(int i=0;i<proArray.length();i++){


                JSONObject proJson = proArray.getJSONObject(i);

                ProductoModel prod= new ProductoModel();

                prod.setNombre(proJson.getString("nombre"));
                prod.setCantidad(proJson.getInt("cantidad"));
                prod.setPrecio(proJson.getInt("precio"));

                proList.add(prod);

            }
          //  MainActivity.listPerAux.addAll(perList);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Log.d("hola", String.valueOf(perList));
        return proList;
    }
}
