package com.example.androidparcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

/* GRUPO: 1
* José Méndez
* Renan Mariscal
* Pedro Castillo
* Alejandro de Puy
* Francisco Chacon
* */

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String titulo[],director[],sinop[];
    int posters[]={R.drawable.poster_drstrange, R.drawable.poster_animalesfantasticos, R.drawable.poster_sonic2, R.drawable.poster_mobius,
            R.drawable.poster_batman, R.drawable.poster_uncharted, R.drawable.poster_matrix, R.drawable.poster_spiderman,
            R.drawable.poster_ethernals, R.drawable.poster_shangchi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.main_recycler_cards);
        titulo=getResources().getStringArray(R.array.pelicula_nombre);
        director=getResources().getStringArray(R.array.pelicula_director);
        sinop=getResources().getStringArray(R.array.pelicula_sinopsis_body);

        AdapterDatos adapterDatos=new AdapterDatos(this, titulo,director,sinop,posters);
        recyclerView.setAdapter(adapterDatos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}