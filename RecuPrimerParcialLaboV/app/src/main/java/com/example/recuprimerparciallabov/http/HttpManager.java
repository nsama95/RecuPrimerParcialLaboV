package com.example.recuprimerparciallabov.http;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpManager {
    public String getData(String urlLink) throws IOException {
        URL url=new URL(urlLink);
        //open conexion
        HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
        // send
       urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        int response= urlConnection.getResponseCode();

        Log.d("response: ", String.valueOf(response));
        if( response == 200){
            //enlace a la conexion
            InputStream is =urlConnection.getInputStream();
            //traigo los datos de a porciones
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            //recorro el string por un buffer
            byte[] buffer= new byte[1024];
            int legth=0;
            while ((legth=is.read(buffer))!=-1){
                bos.write(buffer,0,legth);
            }
            is.close();
            return  new String(bos.toByteArray());

        }else{
            throw  new RuntimeException("error");
        }
    }
}
