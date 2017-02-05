package com.example.william.retoandroid_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by william on 03/02/2017.
 */

public class Secundario extends AppCompatActivity {
    ListView listado;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundolayout);
        listado = (ListView) findViewById(R.id.listView);
        ObtDatos();
    }

    public void ObtDatos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url= "http://victorcasass.com/api/lista_pokemons.php";

        RequestParams parametros= new RequestParams();
        parametros.put("nombre","Bulbasaur");

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, org.apache.http.Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    CargaLista(obtDatosJSON( new String(responseBody)));
                }
            }

            @Override
            public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public void CargaLista(ArrayList<String> datos){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adapter);

    }

    public ArrayList<String> obtDatosJSON(String response){
        ArrayList<String> listado = new ArrayList<>();
        try{
            JSONArray jsonArray = new JSONArray(response);
            String texto;
            for (int i = 0 ; i<jsonArray.length();i++){
                texto = jsonArray.getJSONObject(i).getString("nombre") +"\n "+
                        jsonArray.getJSONObject(i).getString("tipo") +" \n"+
                        jsonArray.getJSONObject(i).getString("imagen") +"\n ";
                listado.add(texto);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listado;
    }

}
