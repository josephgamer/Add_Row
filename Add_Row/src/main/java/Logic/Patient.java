package Logic;

import java.util.HashMap;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:34 a. m.
 */
public class Patient {
    private String id;
    private String nombre;
    private HashMap<String, Disease> enfermedades;

    public Patient() {
        this.id = "";
        this.nombre = "";
        this.enfermedades = new HashMap<>();
    }

    public Patient(String id, String nombre, HashMap<String, Disease> enfermedades) {
        this.id = id;
        this.nombre = nombre;
        this.enfermedades = enfermedades;
    }

    public Patient(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Disease> getEnfermedades() {
        return enfermedades;
    }
}
