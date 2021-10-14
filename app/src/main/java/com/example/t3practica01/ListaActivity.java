package com.example.t3practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {
    ArrayList<ListaContactos> varContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        ListView lViewContacto = findViewById(R.id.listaC);
        //contactos
        varContacto = new ArrayList<>();
        varContacto.add(new ListaContactos("Mabel Terrones", 123456789));
        varContacto.add(new ListaContactos("Sofia Rodriguez", 345678912));
        varContacto.add(new ListaContactos("Micaela Ordoñez", 567891234));
        varContacto.add(new ListaContactos("Renato Vilchez", 563214789));
        varContacto.add(new ListaContactos("Angel Cotrina", 976254138));
        varContacto.add(new ListaContactos("Sizary Pareja", 852369741));
        varContacto.add(new ListaContactos("Susana Carrion", 159632478));
        varContacto.add(new ListaContactos("Miguel Sanchez", 963217485));
        varContacto.add(new ListaContactos("Pricila Pareja", 852463179));
        varContacto.add(new ListaContactos("Juan Ordoñez", 885236941));

        ArrayList<String> nombreC = new ArrayList<>();
        for (ListaContactos cont : varContacto) {
            nombreC.add(cont.getNombre());
        }
        //llenamos la lista view
        lViewContacto.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreC));

        //voy a contactosactivity
        lViewContacto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaActivity.this, ContactosActivity.class);
                intent.putExtra("NombreContacto", varContacto.get(position).getNombre());
                intent.putExtra("NumeroContacto", varContacto.get(position).getCelular());
                startActivity(intent);
            }
        });
    }
}