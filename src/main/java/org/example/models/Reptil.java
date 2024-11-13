package org.example.models;

public class Reptil extends Animal {

    private boolean venenoso;

    public Reptil(String nombre, int edad, EstadoSauld estadoSauld, boolean venenoso) {
        super(nombre, edad, estadoSauld);
        super.tipo = "Reptil";
        this.venenoso = venenoso;
    }

    public Reptil() {
    }

    public boolean isVenenoso() {
        return venenoso;
    }

    public void setVenenoso(boolean venenoso) {
        this.venenoso = venenoso;
    }

    @Override
    public String toString() {
        return "Reptil{" +
                "venenoso=" + venenoso +
                "} " + super.toString();
    }


}
