package com.example.evaluacionlpdm;

import static com.example.evaluacionlpdm.MainActivity.lstPublicaciones;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.evaluacionlpdm.Clases.Publicacion;
import com.example.evaluacionlpdm.Clases.Libro;
import com.example.evaluacionlpdm.Clases.Revista;

import java.util.ArrayList;

public class MostrarLista extends AppCompatActivity{
    private ListView lsvPublicaciones;

    ArrayAdapter<Publicacion> lstFiltradaAdapter;
    ArrayList<Publicacion> lstFiltrada;
    Bundle bundle;


    int idEleccion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        lsvPublicaciones = findViewById(R.id.lsvPublicaciones);

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoMostrarEleccion");
        lstFiltrada = filtrarListaPorSeleccion(idEleccion);

        lstFiltradaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lstFiltrada);
        lsvPublicaciones.setAdapter(lstFiltradaAdapter);

        lsvPublicaciones.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MostrarLista.this);
                builder.setTitle("Eliminar Publicación");
                builder.setMessage("¿Estas seguro que quieres eliminar esta publicación?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        lstPublicaciones.remove(position);
                        lstFiltrada.remove(position);
                        lstFiltradaAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
                return true;
            }
        });
    }

    private ArrayList<Publicacion> filtrarListaPorSeleccion(int eleccion) {
        ArrayList<Publicacion> listaFiltrada = new ArrayList<>();

        for (Publicacion publicacion : lstPublicaciones) {
            switch (eleccion) {
                case 1:
                    if (publicacion instanceof Libro) {
                        listaFiltrada.add(publicacion);
                    }
                    break;
                case 2:
                    if (publicacion instanceof Revista) {
                        listaFiltrada.add(publicacion);
                    }
                    break;
                default:
                    listaFiltrada.add(publicacion);
                    break;
            }
        }
        return listaFiltrada;
    }
}
