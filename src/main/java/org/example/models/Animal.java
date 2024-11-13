package org.example.models;

public abstract class Animal {
    private String nombre;
    private int edad;
    protected String tipo;
    private EstadoSauld estadoSalud;

    public Animal(String nombre, int edad, EstadoSauld estadoSalud) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = "Animal";
        this.estadoSalud = estadoSalud;
    }

    public Animal() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EstadoSauld getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(EstadoSauld estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tipo='" + tipo + '\'' +
                ", estadoSalud=" + estadoSalud +
                '}';
    }

}
