package org.example.data;

import java.io.File;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GestorArchivo {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Opción Uno: Utilización de Genéricos

    // Método genérico para guardar un solo personaje en un archivo JSON
    public static <T> void guardarData(T personaje, String nombreArchivo) {
        try {
            mapper.writeValue(new File(nombreArchivo), personaje);
            System.out.println("data guardada en " + nombreArchivo);
        } catch (Exception e) {
            System.err.println("Error " + nombreArchivo + ": " + e.getMessage());
        }
    }

    // Método genérico para guardar una lista de personajes en un archivo JSON
    public static <T> void guardarListaData(List<T> lista, String nombreArchivo) {
        try {
            mapper.writeValue(new File(nombreArchivo), lista);
            System.out.println("Lista guardada en " + nombreArchivo);
        } catch (Exception e) {
            System.err.println("Error al guardar la lista en " + nombreArchivo + ": " + e.getMessage());
        }
    }

    // Método genérico para leer un solo personaje desde un archivo JSON
    public static <T> T leerDataGenerico(String nombreArchivo, Class<T> claseTipo) {
        try {
            return mapper.readValue(new File(nombreArchivo), claseTipo);
        } catch (Exception e) {
            System.err.println("Error al leer desde " + nombreArchivo + ": " + e.getMessage());
            return null;
        }
    }

    // Método genérico para leer una lista de personajes desde un archivo JSON
    public static <T> List<T> leerListaDataGenerico(String nombreArchivo, Class<T> claseTipo) {
        try {
            return mapper.readValue(new File(nombreArchivo),
                    mapper.getTypeFactory().constructCollectionType(List.class, claseTipo));
        } catch (Exception e) {
            System.err.println("Error al leer la lista desde " + nombreArchivo + ": " + e.getMessage());
            return null;
        }
    }
}