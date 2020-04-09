package Ventana_Principal.Model.Controller;

import Ventana_Principal.Model.ModelPrincipal;
import Ventana_Principal.Model.View.ViewPrincipal;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:06 a. m.
 */
public class ControllerPrincipal {
    ModelPrincipal model;
    ViewPrincipal view;

    public ControllerPrincipal(ModelPrincipal model, ViewPrincipal view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    public ControllerPrincipal(){}
}
