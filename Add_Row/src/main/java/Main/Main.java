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


    }

    public static Window_Patient.Controller WINDOW_PATIENT;
}
