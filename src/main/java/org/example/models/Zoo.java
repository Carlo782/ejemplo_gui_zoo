package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private String nombre;
    private String ubicacion;
    private List<Ave> aves;
    private List<Mamifero> mamiferos;
    private List<Reptil> reptiles;

    public Zoo(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.aves = new ArrayList<>();
        this.mamiferos = new ArrayList<>();
        this.reptiles = new ArrayList<>();
    }

    public Zoo() {
        this.nombre = "Zoologico";
        this.ubicacion = "Ubicación Predeterminada";
        this.aves = new ArrayList<>();
        this.mamiferos = new ArrayList<>();
        this.reptiles = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Ave> getAves() {
        return aves;
    }

    public void setAves(List<Ave> aves) {
        this.aves = aves;
    }

    public List<Mamifero> getMamiferos() {
        return mamiferos;
    }

    public void setMamiferos(List<Mamifero> mamiferos) {
        this.mamiferos = mamiferos;
    }

    public List<Reptil> getReptiles() {
        return reptiles;
    }

    public void setReptiles(List<Reptil> reptiles) {
        this.reptiles = reptiles;
    }

    public void addAve(Ave ave) {
        this.aves.add(ave);
    }

    public void addMamifero(Mamifero mamifero) {
        this.mamiferos.add(mamifero);
    }

    public void addReptil(Reptil reptil) {
        this.reptiles.add(reptil);
    }

    public void removeAve(int index) {
        this.aves.remove(index);
    }

    public void removeMamifero(int index) {
        this.mamiferos.remove(index);
    }

    public void removeReptil(int index) {
        this.reptiles.remove(index);
    }
    
}
