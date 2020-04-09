package Ventana_Principal.Model;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 12:03 p. m.
 */
public class Model extends Observable {

    public Model() {

    }

    public void addObserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
}
