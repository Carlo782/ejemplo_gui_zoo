package org.example.gui;

import org.example.controller.ZooController;
import org.example.models.Ave;
import org.example.models.EstadoSauld;
import org.example.models.Mamifero;
import org.example.models.Reptil;
import org.example.models.Zoo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpcionesAnimalesVista extends JFrame {
    private JPanel mainPanel;
    private JPanel paneloUno;
    private JLabel labelNombre;
    private JTextField campoNombre;
    private JTextField campoEdad;
    private JComboBox<String> campoEstado;
    private JLabel labelEdad;
    private JLabel labelEstado;
    private JLabel labelTipo;
    private JComboBox<String> campoTipo;
    private JPanel panelAve;
    private JPanel panelMamifero;
    private JPanel panelReptil;
    private JCheckBox checkBoxAve;
    private JCheckBox vuelaCheckBox;
    private JCheckBox marinoCheckBox;
    private JCheckBox sangreFriaCheckBox;
    private JButton crearAnimalButton;

    public OpcionesAnimalesVista(Zoo zoo, VistaZoo vista) {
        // Configuración inicial del JFrame
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(mainPanel);
        // Llenar el ComboBox campoTipo con opciones
        campoTipo.addItem("Ave");
        campoTipo.addItem("Mamífero");
        campoTipo.addItem("Reptil");

        // Llenar el ComboBox campoEstado con opciones
        for (EstadoSauld estado : EstadoSauld.values()) {
            campoEstado.addItem(estado.toString()); 
        }

        // Configurar la visibilidad inicial de los paneles
        panelAve.setVisible(false);
        panelMamifero.setVisible(false);
        panelReptil.setVisible(false);

        campoTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el tipo seleccionado
                String selectedType = (String) campoTipo.getSelectedItem();

                // Ocultar todos los paneles
                panelAve.setVisible(false);
                panelMamifero.setVisible(false);
                panelReptil.setVisible(false);

                // Mostrar solo el panel correspondiente
                if (selectedType.equals("Ave")) {
                    panelAve.setVisible(true);
                } else if (selectedType.equals("Mamífero")) {
                    panelMamifero.setVisible(true);
                } else if (selectedType.equals("Reptil")) {
                    panelReptil.setVisible(true);
                }
            }
        });
        crearAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarAnimal(zoo);
                vista.cargarDatos(zoo);
                dispose();
            }
        });
    }

    public void guardarAnimal(Zoo zoo) {
        String nombre = campoNombre.getText();
        int edad = Integer.parseInt(campoEdad.getText());
        String estado = (String) campoEstado.getSelectedItem();
        EstadoSauld estadoSalud = EstadoSauld.valueOf(estado);
        String tipo = (String) campoTipo.getSelectedItem();

        if (tipo.equals("Ave")) {
            ZooController.addAnimal(zoo, opcionAve(nombre, edad, estadoSalud, tipo)) ;
        } else if (tipo.equals("Mamífero")) { 
            ZooController.addAnimal(zoo, opcionMamifero(nombre, edad, estadoSalud, tipo));
        } else if (tipo.equals("Reptil")) {
            ZooController.addAnimal(zoo, opcionReptil(nombre, edad, estadoSalud, tipo));
        }
    }

    public Ave opcionAve(String nombre, int edad, EstadoSauld estado, String tipo) {
        boolean patas = checkBoxAve.isSelected();
        boolean vuela = vuelaCheckBox.isSelected();
        Ave ave = new Ave(nombre, edad, estado, patas, vuela);
        JOptionPane.showMessageDialog(null, ave);
        return ave;
    }

    public Mamifero opcionMamifero(String nombre, int edad, EstadoSauld estado, String tipo) {
        boolean marino = marinoCheckBox.isSelected();
        Mamifero mamifero = new Mamifero(nombre, edad, estado, marino);        
        JOptionPane.showMessageDialog(null, mamifero);
        return mamifero;
    }

    public Reptil opcionReptil(String nombre, int edad, EstadoSauld estado, String tipo) {
        boolean sangreFria = sangreFriaCheckBox.isSelected();
        Reptil reptil = new Reptil(nombre, edad, estado, sangreFria);
        JOptionPane.showMessageDialog(null, reptil);
        return reptil;
    }
}


