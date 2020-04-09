package Ventana_Principal.Model.View;

import Heritage.WindowJFrame;
import Ventana_Principal.Model.Controller.Controller;
import Ventana_Principal.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 12:04 p. m.
 */
public class View extends WindowJFrame implements Observer {
    Model model;
    Controller controller = new Controller();
    private JDesktopPane back;
    private JMenuBar menuPrincipal;
    private JMenu menu1;
    private JMenu menu2;
    JMenuItem item1;
    JMenuItem item2;

    public View() {
        super("Ventana Principal");
        this.setSize(new Dimension(1000, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.back = new JDesktopPane();
        this.menuPrincipal = new JMenuBar();
        this.menu1 = new JMenu("File");
        this.menu2 = new JMenu("Ver");
        this.item1 = new JMenuItem("Registro de Pacientes");
        this.item2 = new JMenuItem("Ver Pacientes");
        this.menu1.add(item1);
        this.menu2.add(item2);
        this.menuPrincipal.add(menu1);
        this.menuPrincipal.add(menu2);
        this.setJMenuBar(menuPrincipal);
        this.add(back);
        eventActionListenerItem1();
        eventActionListenerItem2();
    }

    public void addJInternalFrame(Component c) {
        this.back.add(c);
    }

    private void eventActionListenerItem1() {
        this.item1.addActionListener(actionEvent -> {
            controller.showRegisterPatients();
        });
    }

    private void eventActionListenerItem2() {
        this.item2.addActionListener(actionEvent -> {
            controller.showListadoPatients();
        });
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
