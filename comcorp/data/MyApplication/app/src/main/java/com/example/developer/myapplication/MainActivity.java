package com.example.developer.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button elBoton;
    private TextView elTexto;
    //todos los elementos de xml, los elementos visuales, son todos 'View'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elBoton = (Button) findViewById(R.id.el_boton);
        elTexto = (TextView) findViewById(R.id.texto);

        elBoton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return false;
            }
        });
        elBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elTexto.setText(getString(R.string.nuevo_texto));

                elTexto.getText().
//                if(elTexto.getText().equals(R.string.texto)){
//                   elTexto.setText(getString(R.string.otro_texto));
//                }else{
//                    elTexto.setText(getString(R.string.texto));
//                }
// elBoton.setText("ahre");
            }
        });
    }


}
