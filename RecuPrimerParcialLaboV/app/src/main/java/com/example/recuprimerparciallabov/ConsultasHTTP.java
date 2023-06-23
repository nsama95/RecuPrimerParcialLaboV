package com.example.recuprimerparciallabov;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.os.Handler;
import org.json.JSONException;

import java.io.IOException;

public class ConsultasHTTP implements  Runnable{
    String url;
    Handler handler;
    public ConsultasHTTP(String url,Handler handler){
        this.url=url;
        this.handler=handler;
    }
    @Override
    public void run() {
        HttpManager manager= new HttpManager();
        try {
            Log.d("hola url",url.toString());
            Message message= new Message();
            message.arg1=1;
            String personaJson=manager.getData(url);
            message.obj=ParserJson.parsearJSON(personaJson);
            message.arg2=2;

            Log.d("respuesta:", message.obj.toString());
            handler.sendMessage(message);
            //

        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
