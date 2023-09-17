package com.example.evaluacionlpdm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
public class ElegirMostrarPublicacion extends AppCompatActivity{
    private RadioButton rbLibro,rbRevista,rbAmbos;
    private RadioGroup rgbEleccion;
    private Button btnMostrar;
    private Bundle bundle;

    private int idEleccion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_mostrar_publicacion);

        rgbEleccion = findViewById(R.id.rgEleccion);
        rbLibro = rgbEleccion.findViewById(R.id.rgLibro);
        rbRevista = rgbEleccion.findViewById(R.id.rgRevista);
        rbAmbos = rgbEleccion.findViewById(R.id.rgAmbos);
        btnMostrar = findViewById(R.id.btnMostrar);

        rbLibro.setOnClickListener(view -> idEleccion = 1);
        rbRevista.setOnClickListener(view -> idEleccion = 2);
        rbAmbos.setOnClickListener(view -> idEleccion = 3);


        btnMostrar.setOnClickListener(view -> {
            bundle = new Bundle();
            bundle.putInt("tipoMostrarEleccion", idEleccion);
            Intent intent = new Intent(this, MostrarLista.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }


}
