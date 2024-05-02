package com.example.androidparcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_pelicula extends AppCompatActivity {

    ImageView iv_poster;
    TextView tv_titulo,tv_director,tv_sinop;
    String titulo,director,sinop;
    int posters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

        tv_titulo=findViewById(R.id.pelicula_nombre);
        tv_director=findViewById(R.id.pelicula_director);
        tv_sinop=findViewById(R.id.pelicula_sinopsis_body);
        iv_poster=findViewById(R.id.pelicula_poster);

        getData();
        setData();


    }
    private void setData(){
        tv_titulo.setText(titulo);
        tv_director.setText(director);
        tv_sinop.setText(sinop);
        iv_poster.setImageResource(posters);
    }

    private void getData() {
        if (getIntent().hasExtra("data_poster") && getIntent().hasExtra("data_titulo") && getIntent().hasExtra("data_director") && getIntent().hasExtra("data_sinop")) {
            titulo = getIntent().getStringExtra("data_titulo");
            director = getIntent().getStringExtra("data_director");
            sinop = getIntent().getStringExtra("data_sinop");
            posters = getIntent().getIntExtra("data_poster", 1);
        } else {
            Toast.makeText(this, "No hay datos", Toast.LENGTH_LONG).show();
        }
    }

}