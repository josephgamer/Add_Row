package Window_Patient;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:41 a. m.
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

    public void show() {
        this.view.setVisible(true);
    }
}
