package com.example.william.retoandroid_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.btnIngresar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = ((EditText) findViewById(R.id.txtUsuario)).getText().toString();
                String password = ((EditText) findViewById(R.id.txtPassword)).getText().toString();
                if (usuario.equals("Bulbasaur") && password.equals("Planta")){
                    Intent nuevoform = new Intent(MainActivity.this,Secundario.class);
                    startActivity(nuevoform);
                }else if (usuario.equals("Ivysaur") && password.equals("Planta")){
                    Intent nuevoform = new Intent(MainActivity.this,Secundario.class);
                    startActivity(nuevoform);
                }else if (usuario.equals("Venusaur") && password.equals("Planta")){
                    Intent nuevoform = new Intent(MainActivity.this,Secundario.class);
                    startActivity(nuevoform);
                }else if (usuario.equals("Charmander") && password.equals("Fuego")){
                    Intent nuevoform = new Intent(MainActivity.this,Secundario.class);
                    startActivity(nuevoform);
                }else if (usuario.equals("Charmeleon") && password.equals("Fuego")){
                    Intent nuevoform = new Intent(MainActivity.this,Secundario.class);
                    startActivity(nuevoform);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
