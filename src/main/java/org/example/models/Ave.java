package org.example.models;

public class Ave extends Animal {
    private boolean patasPalmeadas;
    private boolean vuela;

    public Ave(String nombre, int edad, EstadoSauld estadoSauld , boolean patasPalmeadas ,boolean vuela) {
        super(nombre, edad, estadoSauld);
        super.tipo = "Ave";
        this.patasPalmeadas = patasPalmeadas;
        this.vuela = vuela;
    }

    public Ave() {       
    }

    public boolean isPatasPalmeadas() {
        return patasPalmeadas;
    }

    public void setPatasPalmeadas(boolean patasPalmeadas) {
        this.patasPalmeadas = patasPalmeadas;
    }

    public boolean isVuela() {
        return vuela;
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }

    @Override
    public String toString() {
        return "Ave{" +
                "vuela=" + vuela +
                "} " + super.toString();
    }

}

