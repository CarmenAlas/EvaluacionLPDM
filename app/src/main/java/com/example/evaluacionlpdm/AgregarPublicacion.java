package com.example.evaluacionlpdm;

import static com.example.evaluacionlpdm.MainActivity.lstPublicaciones;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evaluacionlpdm.Clases.Libro;
import com.example.evaluacionlpdm.Clases.Revista;

public class AgregarPublicacion extends  AppCompatActivity{
    private EditText edtCodigoPub, edtTituloPub, edtAnioPub, edtNumRevista;
    private Button btnProcesar;

    private Bundle bundle;

    private int idEleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_publicacion);

        edtCodigoPub = findViewById(R.id.edtCodigo);
        edtTituloPub = findViewById(R.id.edtTitulo);
        edtAnioPub = findViewById(R.id.edtAnio);
        edtNumRevista = findViewById(R.id.edtNumeroRevista);
        btnProcesar = findViewById(R.id.btnProcesar);

        bundle = getIntent().getExtras();
        idEleccion = bundle.getInt("tipoEleccion");

        if(idEleccion == 1){
            // Es libro
            edtNumRevista.setVisibility(View.GONE);
        }

        btnProcesar.setOnClickListener(view -> {
            if(edtNumRevista.getText().toString().isEmpty()){
                lstPublicaciones.add(
                        new Libro(
                                Integer.valueOf(edtCodigoPub.getText().toString()),
                                edtTituloPub.getText().toString(),
                                Integer.valueOf(edtAnioPub.getText().toString()),
                                false));
            } else {
                lstPublicaciones.add(
                        new Revista(
                                Integer.valueOf(edtCodigoPub.getText().toString()),
                                edtTituloPub.getText().toString(),
                                Integer.valueOf(edtAnioPub.getText().toString()),
                                Integer.valueOf(edtNumRevista.getText().toString())
                        )
                );


            }

            // Una vez insertado el registro, se puede mostrar una alerta y sacar de la pila a la actvidad
            new AlertDialog.Builder(this).setMessage("Insertado con éxito")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();
        });
    }
}
