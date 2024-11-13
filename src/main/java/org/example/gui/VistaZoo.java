package org.example.gui;

import org.example.controller.ZooController;
import org.example.models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaZoo extends JFrame {
    private JPanel mainPanel;
    private JTable tablaAnimales;
    private JButton eliminarAnimalButton;
    private JButton agregarAnimalButton;
    private JButton guardarInformaciónButton;

    public VistaZoo(Zoo zoo) {
        setTitle("Zoo");
        setSize(650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(mainPanel);

        String[] columnas = { "Nombre", "Edad", "Tipo", "Estado de Salud" };

        DefaultTableModel model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaAnimales.setModel(model);
        cargarDatos(zoo);

        tablaAnimales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && tablaAnimales.getSelectedRow() != -1) {
                    int filaSeleccionada = tablaAnimales.getSelectedRow();
                    mostrarDetallesAnimal(zoo, filaSeleccionada);
                }
            }
        });
        eliminarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaAnimales.getSelectedRow();
                if (filaSeleccionada != -1 ) {
                    eliminarAnimal(zoo, filaSeleccionada);
                    cargarDatos(zoo); // Actualizar la tabla
                } else {
                    JOptionPane.showMessageDialog(VistaZoo.this, "Seleccione un animal para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        guardarInformaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZooController.saveData(zoo);
                JOptionPane.showMessageDialog(VistaZoo.this, "Datos guardados correctamente.", "Guardado exitoso", JOptionPane.INFORMATION_MESSAGE);
                
            }
        });
        agregarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            OpcionesAnimalesVista opcionesAnimalesVista = new OpcionesAnimalesVista(zoo, VistaZoo.this);
            opcionesAnimalesVista.setVisible(true);
            }
        });
    }

    public void cargarDatos(Zoo zoo) {
        DefaultTableModel model = (DefaultTableModel) tablaAnimales.getModel();
        model.setRowCount(0);
        for (Ave ave : zoo.getAves()) {
            model.addRow(new Object[] { ave.getNombre(), ave.getEdad(), "Ave", ave.getEstadoSalud() });
        }
        for (Mamifero mamifero : zoo.getMamiferos()) {
            model.addRow(new Object[] { mamifero.getNombre(), mamifero.getEdad(), "Mamifero", mamifero.getEstadoSalud() });
        }
        for (Reptil reptil : zoo.getReptiles()) {
            model.addRow(new Object[] { reptil.getNombre(), reptil.getEdad(), "Reptil", reptil.getEstadoSalud() });
        }
    }

    private void mostrarDetallesAnimal(Zoo zoo, int filaSeleccionada) {
        String tipo = (String) tablaAnimales.getValueAt(filaSeleccionada, 2);
        String detalles = "Detalles del Animal:\n";

        int index = filaSeleccionada;

        if (tipo.equals("Ave")) {
            detalles = opcionAve(zoo, index);
        } else if (tipo.equals("Mamifero")) {
            index -= zoo.getAves().size();
            detalles = opcionMamifero(zoo, index);
        } else if (tipo.equals("Reptil")) {
            index -= (zoo.getAves().size() + zoo.getMamiferos().size());
            detalles = opcionReptil(zoo, index);
        }
        JOptionPane.showMessageDialog(this, detalles, "Detalles del Animal", JOptionPane.INFORMATION_MESSAGE);
    }

    private String opcionAve(Zoo zoo, int index) {
        Ave ave = zoo.getAves().get(index);
        return ave.toString();
    }

    private String opcionMamifero(Zoo zoo, int index) {
        Mamifero mamifero = zoo.getMamiferos().get(index);
        return mamifero.toString();
    }

    private String opcionReptil(Zoo zoo, int index) {
        Reptil reptil = zoo.getReptiles().get(index);
        return reptil.toString();
    }

    
    private void eliminarAnimal(Zoo zoo, int selectedRow) {
        String tipo = (String) tablaAnimales.getValueAt(selectedRow, 2);
        int index = selectedRow;

        try {
            if (tipo.equals("Ave")) {
                ZooController.removeAnimal(zoo, "Ave", index);
            } else if (tipo.equals("Mamifero")) {
                index -= zoo.getAves().size();
                ZooController.removeAnimal(zoo, "Mamifero", index);
            } else if (tipo.equals("Reptil")) {
                index -= (zoo.getAves().size() + zoo.getMamiferos().size());
                ZooController.removeAnimal(zoo, "Reptil", index);
            }
            JOptionPane.showMessageDialog(this, "Animal eliminado correctamente.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el animal.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}
