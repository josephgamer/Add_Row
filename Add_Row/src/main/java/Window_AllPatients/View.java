package Window_AllPatients;

import Heritage.WindowJInternalFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 01:07 p. m.
 */
public class View extends WindowJInternalFrame implements Observer {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnListar;
    Model model = new Model();
    Controller controller = new Controller();

    public View() {
        super("Listar Pacientes");
        this.setClosable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(new Dimension(638, 299));

        this.table = new JTable();
        this.tableModel = new DefaultTableModel();
        this.btnListar = new JButton("Listar pacientes");
        this.table.setModel(model.getTablePatient());
        this.btnListar.setBounds(new Rectangle(450, 4, 160, 30));
        table.setName("table");


        JPanel ctrlPane = new JPanel();
        ctrlPane.setName("ctrlPanel");
        ctrlPane.setLayout(null);
        ctrlPane.add(btnListar);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setName("scrollTablePanePatient");
        tableScrollPane.setPreferredSize(new Dimension(700, 182));
        tableScrollPane.setViewportView(table);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ver pacientes",
                TitledBorder.CENTER, TitledBorder.TOP));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
        splitPane.setName("splitPane");
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);
        add(splitPane);
        pack();
        eventActionListenerBtnListar();
    }

    private void eventActionListenerBtnListar() {
        this.btnListar.addActionListener(actionEvent -> {
            controller.seeAllPatients();
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
        this.table.setModel(model.getTablePatient());
    }
}
