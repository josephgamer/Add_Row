package Window_Patient;

import Logic.Patient;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:41 a. m.
 */
public class Model extends Observable {
    private Patient patient;

    public Model() {
        this.patient=new Patient();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
        this.setChanged();
        this.notifyObservers();
    }

    public void addObserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
}
