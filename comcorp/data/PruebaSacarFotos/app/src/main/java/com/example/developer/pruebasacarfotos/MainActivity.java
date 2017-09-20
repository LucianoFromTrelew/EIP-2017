package com.example.developer.pruebasacarfotos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private static final int CAMARA_REQUEST = 200;
    private Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE),
                        CAMARA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMARA_REQUEST){
            if(data != null){
                Bitmap nImage = (Bitmap) data.getExtras().get("data");
                ImageView imagen = (ImageView) findViewById(R.id.imagen);
                imagen.setImageBitmap(nImage);
            }
        }
    }
}
