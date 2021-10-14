package com.example.t3practica01;

public class ListaContactos {
    String Nombre;
    int Celular;

    public ListaContactos(String nombre, int celular) {
        Nombre = nombre;
        Celular = celular;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int celular) {
        Celular = celular;
    }
}
