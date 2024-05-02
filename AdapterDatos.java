package com.example.androidparcial2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    String data_titulo[], data_sinop[], data_director[];
    int data_poster[];

    Context context;


//el adaptador recibe la lista de datos
    public AdapterDatos(Context _ct, String[] _data_titulo, String[] _data_director, String[] _data_sinop,
                        int[] _img_poster) {
        context = _ct;
        data_sinop = _data_sinop;
        data_titulo = _data_titulo;
        data_director = _data_director;
        data_poster = _img_poster;
    }

    @NonNull
    @Override
//  Enlaza el adaptador con el layout a repetir
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_card_pelicula, parent, false);
        return new ViewHolderDatos(view);
    }


// Asigna la data al elemento
    @Override
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolderDatos holder, @SuppressLint("RecyclerView") int position) {
        holder.asig_pelicula_titulo.setText(data_titulo[position]);
        holder.aisg_pelicula_director.setText(data_director[position]);
        holder.asig_pelicula_poster.setImageResource(data_poster[position]);
        /*Aisgna acción de botón a cada card*/
        holder.action_card_pelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,activity_pelicula.class );
                intent.putExtra("data_titulo",data_titulo[position]);
                intent.putExtra("data_director",data_director[position]);
                intent.putExtra("data_sinop",data_sinop[position]);
                intent.putExtra("data_poster",data_poster[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_poster.length;
    }

//    Metodo que referencia el adaptador al elemento en el layout
    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView asig_pelicula_titulo, aisg_pelicula_director;
        ImageView asig_pelicula_poster;
        CardView action_card_pelicula;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            asig_pelicula_titulo =itemView.findViewById(R.id.card_pelicula_nombre);
            aisg_pelicula_director =itemView.findViewById(R.id.card_pelicula_director);
            asig_pelicula_poster =itemView.findViewById(R.id.card_pelicula_poster);
            action_card_pelicula=itemView.findViewById(R.id.card_pelicula);
        }
    }
}
