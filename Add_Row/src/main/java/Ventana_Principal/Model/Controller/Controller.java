package Ventana_Principal.Model.Controller;

import Main.Main;
import Ventana_Principal.Model.Model;
import Ventana_Principal.Model.View.View;

/**
 * @author Esteban
 * @created 09/04/2020 - 12:04 p. m.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    public Controller(){}

    public void showRegisterPatients() {
        Main.WINDOW_PATIENT.show();
    }
}
