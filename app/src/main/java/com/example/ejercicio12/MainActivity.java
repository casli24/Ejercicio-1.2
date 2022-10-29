package com.example.ejercicio12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtnombre,txtapellido,txtedad,txtcorreo;
    Button envia;
    Intent extraer;
    int turno=1;
    public boolean validar(String dato,int numero){
        String opcion1="[a-z,0-9]{3,50}[@][a-z,0-9]{3,50}[.][a-z]{2,10}";
        String opcion2="[a-z,0-9]{3,50}[.][a-z,0-9]{3,50}[@][a-z,0-9]{3,50}[.][a-z]{2,10}";
        String opcion3="[a-z,0-9]{3,50}[.][a-z,0-9]{3,50}[.][a-z,0-9]{3,50}[@][a-z,0-9]{3,50}[.][a-z]{2,10}";
        String opcion4="[A-Z,Á,É,Í,Ó,Ú,Ñ][a-z,á,é,í,ó,ú,ñ]{2,50}";
        String opcion5="[A-Z,Á,É,Í,Ó,Ú,Ñ][a-z,á,é,í,ó,ú,ñ]{2,50}[ ][A-Z,Á,É,Í,Ó,Ú,Ñ][a-z,á,é,í,ó,ú,ñ]{2,50}";
        switch(numero){
            case 1:{
                return dato.matches(opcion4+"|"+opcion5);
            }
            case 2:{
                return dato.matches(opcion4+"|"+opcion5);
            }
            case 3:{
                return dato.matches("[0-9]{1,2}");
            }
            case 4:{
                return dato.matches(opcion1+"|"+opcion2+"|"+opcion3);
            }
            default:{
                return false;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnombre=(EditText) findViewById(R.id.nombre);
        txtapellido=(EditText) findViewById(R.id.apellido);
        txtedad=(EditText) findViewById(R.id.edad);
        txtcorreo=(EditText) findViewById(R.id.correo);
        envia=(Button) findViewById(R.id.enviar);
        envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar(txtnombre.getText().toString().trim(),turno)){
                    turno=2;
                    if(validar(txtapellido.getText().toString().trim(),turno)){
                        turno=3;
                        if(validar(txtedad.getText().toString().trim(),turno)){
                            turno=4;
                            if(validar(txtcorreo.getText().toString().trim(),turno)){
                                turno=1;
                                extraer=new Intent(getApplicationContext(),MainActivity2.class);
                                extraer.putExtra("nombre",txtnombre.getText().toString());
                                extraer.putExtra("apellido",txtapellido.getText().toString());
                                extraer.putExtra("edad",txtedad.getText().toString());
                                extraer.putExtra("correo",txtcorreo.getText().toString());
                                startActivity(extraer);
                            }
                            else{
                                turno=1;
                            }
                        }
                        else{
                            turno=1;
                        }
                    }
                    else{
                        turno=1;
                    }
                }
                else{
                    turno=1;
                }
            }
        });
    }
}