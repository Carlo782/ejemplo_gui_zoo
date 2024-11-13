package org.example.controller;

import org.example.data.GestorArchivo;
import org.example.models.Animal;
import org.example.models.Ave;
import org.example.models.Mamifero;
import org.example.models.Reptil;
import org.example.models.Zoo;

import java.util.List;

public class ZooController {
    public static Zoo cargaDatos(Zoo zoo){
      zoo.setAves(GestorArchivo.leerListaDataGenerico("ave.json", Ave.class)); 
      zoo.setMamiferos(GestorArchivo.leerListaDataGenerico("mamifero.json", Mamifero.class));
      zoo.setReptiles(GestorArchivo.leerListaDataGenerico("reptil.json", Reptil.class));
      return zoo;
    }
    
    public static Zoo addAnimal(Zoo zoo, Animal animal) {
        if (animal instanceof Ave) {
            zoo.addAve((Ave) animal);
        }else if (animal instanceof Mamifero) {
            zoo.addMamifero((Mamifero) animal);
        }else if (animal instanceof Reptil) {
            zoo.addReptil((Reptil) animal);
        }else{
            System.out.println("No se pudo agregar el animal");
        }
        return zoo;
    }

    public static void removeAnimal(Zoo zoo, String tipo ,int index) {
        if (tipo.equals("Ave")) {
            zoo.removeAve(index);
        }else if (tipo.equals("Mamifero")) {
            zoo.removeMamifero(index);
        }else if (tipo.equals("Reptil")) {
            zoo.removeReptil(index);
        }else{
            System.out.println("No se pudo eliminar el animal");
        }
    }

    public static void saveData(Zoo zoo){
        GestorArchivo.guardarListaData(zoo.getAves(), "ave.json");
        GestorArchivo.guardarListaData(zoo.getMamiferos(), "mamifero.json");
        GestorArchivo.guardarListaData(zoo.getReptiles(), "reptil.json");
    }
    
}
