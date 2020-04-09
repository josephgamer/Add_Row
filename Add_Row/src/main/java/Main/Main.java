package Main;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:18 a. m.
 */
public class Main {

    public static void main(String[] args) {
        Window_Patient.Model modelEdition = new Window_Patient.Model();
        Window_Patient.View viewEdition = new Window_Patient.View();
        Window_Patient.Controller controllerEdition = new Window_Patient.Controller(modelEdition, viewEdition);
        WINDOW_PATIENT = controllerEdition;

        Ventana_Principal.Model.Model modelPrincipalWindow = new Ventana_Principal.Model.Model();
        Ventana_Principal.Model.View.View viewPrincipalWindow = new Ventana_Principal.Model.View.View();
        Ventana_Principal.Model.Controller.Controller controllerPrincipalWindow = new Ventana_Principal.Model.Controller.Controller(modelPrincipalWindow, viewPrincipalWindow);
        viewPrincipalWindow.setVisible(true);
        viewPrincipalWindow.addJInternalFrame(viewEdition);
    }

    public static Window_Patient.Controller WINDOW_PATIENT;
}
