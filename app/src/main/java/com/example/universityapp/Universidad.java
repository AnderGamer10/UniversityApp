package com.example.universityapp;

class Universidad{
    String nombre;
    String domain;

    public Universidad(String nombre, String domain) {
        this.nombre = nombre;
        this.domain = domain;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}