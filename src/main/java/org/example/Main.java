package org.example;

import org.example.controller.ZooController;
import org.example.gui.VistaZoo;

import org.example.models.Zoo;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Zoo zoo = new Zoo();
        ZooController.cargaDatos(zoo);
        VistaZoo vistaZoo = new VistaZoo(zoo);
        vistaZoo.setVisible(true);

    }

}