package com.example.ejercicio12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText txtnombre,txtapellido,txtedad,txtcorreo;
    Button volver;
    Intent pagina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtnombre=(EditText) findViewById(R.id.nombre2);
        txtapellido=(EditText) findViewById(R.id.apellido2);
        txtedad=(EditText) findViewById(R.id.edad2);
        txtcorreo=(EditText) findViewById(R.id.correo2);
        txtnombre.setText(getIntent().getExtras().getString("nombre"));
        txtapellido.setText(getIntent().getExtras().getString("apellido"));
        txtedad.setText(getIntent().getExtras().getString("edad"));
        txtcorreo.setText(getIntent().getExtras().getString("correo"));
        volver=(Button) findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagina=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(pagina);
            }
        });
    }
}