package com.example.t3practica01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactosActivity extends AppCompatActivity {

    TextView tvNombre, tvNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        //recibo los enviados de lista activity
        Bundle bun = getIntent().getExtras();
        String nombre = bun.getString("NombreContacto");
        int celular = bun.getInt("NumeroContacto");


        tvNombre = (TextView) findViewById(R.id.textName);
        tvNumero = (TextView) findViewById(R.id.textNumber);
        Button btn = findViewById(R.id.btnLlamar);
        Button btn1 = findViewById(R.id.btnSMS);

        tvNombre.setText(nombre);
        tvNumero.setText(""+celular);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+celular));
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" +celular));
                startActivity(intent);
            }
        });
    }
}