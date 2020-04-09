package Window_AllPatients;

/**
 * @author Esteban
 * @created 09/04/2020 - 01:06 p. m.
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

    public Controller() {
    }

    public void seeAllPatients() {
        model.setPatients(Logic.Model.instance().allPatients());
        model.setTablePatient(Logic.Model.instance().allPatients());
    }

    public void show() {
        this.view.setVisible(true);
    }

}
