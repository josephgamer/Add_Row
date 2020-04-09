package Ventana_Principal.Model.View;

import Heritage.WindowJFrame;
import Ventana_Principal.Model.Controller.ControllerPrincipal;
import Ventana_Principal.Model.ModelPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:06 a. m.
 */
public class ViewPrincipal extends WindowJFrame implements Observer {
    private JMenuBar menuPrincipal;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem item1;
    private JMenuItem item2;
    private JDesktopPane background;
    ModelPrincipal model;
    ControllerPrincipal controller;

    public ViewPrincipal() {
        super("Ventana Principal");
        this.setSize(new Dimension(1000, 500));
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.background = new JDesktopPane();
        this.menuPrincipal = new JMenuBar();
        this.menu1 = new JMenu("File");
        this.menu2 = new JMenu("Ver");
        this.item1 = new JMenuItem("Registrar Pacientes");
        this.item2 = new JMenuItem("Ver Pacientes");
        this.menu1.add(item1);
        this.menu2.add(item2);
        this.menuPrincipal.add(menu1);
        this.menuPrincipal.add(menu2);
        this.setJMenuBar(menuPrincipal);
        this.add(background);
    }

    public void addJInternalFrame(Component component) {
        this.background.add(component);
    }

    public ModelPrincipal getModel() {
        return model;
    }

    public ControllerPrincipal getController() {
        return controller;
    }

    public void setModel(ModelPrincipal model) {
        this.model = model;
        model.addOserver(this);
    }

    public void setController(ControllerPrincipal controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
