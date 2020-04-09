package Ventana_Principal.Model;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:05 a. m.
 */
public class ModelPrincipal extends Observable {

    public ModelPrincipal(){}


    public void addOserver(Observer o) {
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }

}
