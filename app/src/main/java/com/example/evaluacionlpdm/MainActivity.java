package com.example.evaluacionlpdm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.example.evaluacionlpdm.Clases.Libro;
import com.example.evaluacionlpdm.Clases.Revista;

import com.example.evaluacionlpdm.Clases.Publicacion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {



    public static ArrayList<Publicacion> lstPublicaciones ;

    private Button btnAgregarPublicacion, btnMostrarLista, btnAcerca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPublicaciones = new ArrayList<>();
        btnAgregarPublicacion = findViewById(R.id.btnAgregar);
        btnMostrarLista = findViewById(R.id.btnMostrarLista);
        btnAcerca = findViewById(R.id.btnAcerca);

        // Configurando evento
        btnAgregarPublicacion.setOnClickListener(this);
        btnMostrarLista.setOnClickListener(this);
        btnAcerca.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, Acerca.class));
        });

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Agregar publicacion
        if(id == R.id.btnAgregar){
            startActivity(new Intent(this, ElegirTipoPublicacion.class));
        }
        if(id == R.id.btnMostrarLista){
            startActivity(new Intent(this, ElegirMostrarPublicacion.class));
        }

    }
}