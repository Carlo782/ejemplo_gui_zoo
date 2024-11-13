package org.example.models;

public class Mamifero extends Animal {
    private boolean mamiferoMarino;


    public Mamifero(String nombre, int edad, EstadoSauld estadoSauld, boolean mamiferoMarino) {
        super(nombre, edad, estadoSauld);
        super.tipo = "Mamifero";
        this.mamiferoMarino = mamiferoMarino;
    }

    public Mamifero() {
    }

    public boolean isMamiferoMarino() {
        return mamiferoMarino;
    }

    public void setMamiferoMarino(boolean mamiferoMarino) {
        this.mamiferoMarino = mamiferoMarino;
    }

    @Override
    public String toString() {
        return "Mamifero{" +
                ", mamiferoMarino=" + mamiferoMarino +
                "} " + super.toString();
    }


}
