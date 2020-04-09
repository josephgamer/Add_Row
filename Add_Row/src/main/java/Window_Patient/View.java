package Window_Patient;

import Heritage.WindowJInternalFrame;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:41 a. m.
 */
public class View extends WindowJInternalFrame implements Observer {
    Model model;
    Controller controller = new Controller();

    public View() {
        super("Registrar Pacientes");
        this.setLayout(null);
        this.setClosable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(new Dimension(468, 262));
    }

    public Model getModel() {
        return model;
    }

    public Controller getController() {
        return controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
