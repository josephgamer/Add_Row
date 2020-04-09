package Logic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:36 a. m.
 */
public class Model {
    HashMap<String, Patient> patients;

    public Model() {
        this.patients = new HashMap<>();
    }

    public void addPatient(Patient patient) {
        this.patients.put(patient.getId(), patient);
    }

    public int totatlPatients() {
        return this.patients.size();
    }

    public ArrayList<Patient> allPatients() {
        return new ArrayList(this.patients.values());
    }

    static Model the_instance;

    public static Model instance() {
        if (the_instance == null) {
            the_instance = new Model();
        }
        return the_instance;
    }
}
