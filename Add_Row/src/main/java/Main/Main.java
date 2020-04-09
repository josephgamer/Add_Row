package Main;

import Ventana_Principal.Model.Controller.ControllerPrincipal;
import Ventana_Principal.Model.ModelPrincipal;
import Ventana_Principal.Model.View.ViewPrincipal;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:18 a. m.
 */
public class Main {

    public static void main(String[] args) {
        ModelPrincipal modelPrincipalWindow = new ModelPrincipal();
        ViewPrincipal viewPrincipalWindow = new ViewPrincipal();
        ControllerPrincipal controllerPrincipalWindow = new ControllerPrincipal
                (modelPrincipalWindow, viewPrincipalWindow);
        viewPrincipalWindow.setVisible(true);
    }
}
