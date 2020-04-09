package Window_AllPatients;

import Logic.Patient;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 01:06 p. m.
 */
public class Model extends Observable {
    ArrayList<Patient> patients;
    int[] cols = {TableModel.ID, TableModel.NOMBRE, TableModel.ENFERMEDAD};
    TableModel table;
    Patient filter;

    public Model() {
        this.patients = new ArrayList<>();
        this.table = new TableModel(cols, new ArrayList<>());
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public Patient getFilter() {
        return filter;
    }

    public TableModel getTablePatient() {
        return table;
    }

    public Patient getRowAt(int row) {
        return table.getRowAt(row);
    }

    public void setFilter(Patient filter) {
        this.filter = filter;
    }

    public void setTablePatient(ArrayList<Patient> patients) {
        this.table = new TableModel(cols, patients);
        setChanged();
        notifyObservers();
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
        this.setChanged();
        this.notifyObservers();
    }

    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
}
