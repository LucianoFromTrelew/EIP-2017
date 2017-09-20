package com.example.developer.myapplication;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ppal extends AppCompatActivity {

    private Button elBoton, otroBoton;
    private TextView elTexto;
    private EditText nombre;
    //todos los elementos de xml, los elementos visuales, son todos 'View'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elBoton = (Button) findViewById(R.id.boton);
        otroBoton = (Button) findViewById(R.id.cambiar_act);
        elTexto = (TextView) findViewById(R.id.texto);


        elBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = (EditText) findViewById(R.id.input);
                String _name = nombre.getText().toString();
                elTexto.setText(
                        _name == "" ? "Como va?" :
                                String.format("Hola %s", _name));
            }
        });

        otroBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Ppal.this, Segunda.class));
            }
        });

    }

    public void pepe(View view){
        Log.d("metodo pepe", "asda");
    }




}
