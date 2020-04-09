package Window_Patient;

import Heritage.WindowJInternalFrame;
import Logic.Disease;
import Logic.Patient;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Esteban
 * @created 09/04/2020 - 11:41 a. m.
 */
public class View extends WindowJInternalFrame implements Observer {
    Model model;
    Controller controller = new Controller();
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblDisease;
    private JLabel lblTotal_Patients;
    private JLabel lblTotal_Diseases;
    private JTextField jtfID;
    private JTextField jtfName;
    private JTextField jtfDisease;
    private JButton btnAdd;
    private JButton btnSave;
    HashMap<String, Disease> enfermedad = new HashMap<>();

    public View() {
        super("Registrar Pacientes");
        this.setLayout(null);
        this.setClosable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(new Dimension(468, 262));
        this.lblID = new JLabel("Cedula:");
        this.lblNombre = new JLabel("Nombre:");
        this.lblDisease = new JLabel("Enfermedad(es):");
        this.lblTotal_Patients = new JLabel("Total Pacientes:");
        this.lblTotal_Diseases = new JLabel("Total enfermedades registradas:");
        this.jtfID = new JTextField("", 10);
        this.jtfName = new JTextField("", 20);
        this.jtfDisease = new JTextField("Ninguna", 50);
        this.btnAdd = new JButton("Agregar");
        this.btnSave = new JButton("Guardar");
        this.lblID.setBounds(new Rectangle(10, 10, 80, 20));
        this.lblNombre.setBounds(new Rectangle(10, 50, 80, 20));
        this.lblDisease.setBounds(new Rectangle(10, 90, 100, 20));
        this.lblTotal_Patients.setBounds(new Rectangle(10, 120, 200, 20));
        this.lblTotal_Diseases.setBounds(new Rectangle(250, 50, 200, 20));
        this.jtfID.setBounds(new Rectangle(115, 10, 120, 20));
        this.jtfName.setBounds(new Rectangle(115, 50, 120, 20));
        this.jtfDisease.setBounds(new Rectangle(115, 90, 120, 20));
        this.btnAdd.setBounds(new Rectangle(250, 90, 80, 20));
        this.btnSave.setBounds(new Rectangle(180, 180, 80, 20));
        this.add(lblID);
        this.add(lblNombre);
        this.add(lblDisease);
        this.add(lblTotal_Patients);
        this.add(lblTotal_Diseases);
        this.add(jtfID);
        this.add(jtfName);
        this.add(jtfDisease);
        this.add(btnAdd);
        this.add(btnSave);
        eventActionListenerBtnAdd();
        eventActionListenerBtnSave();
    }

    public int totalEnfermedades() {
        return this.enfermedad.size();
    }

    public HashMap<String, Disease> returnEnfermedad() {
        return this.enfermedad;
    }

    public boolean isEmpty() {
        return this.jtfID.getText().isEmpty() || this.jtfName.getText().isEmpty();
    }

    public void cleanFields() {
        this.jtfID.setText("");
        this.jtfName.setText("");
    }

    private void eventActionListenerBtnAdd() {
        this.btnAdd.addActionListener(actionEvent -> {
            if (!this.jtfDisease.getText().isEmpty()) {
                Disease d = new Disease(this.jtfDisease.getText());
                this.enfermedad.put(d.getNombre(), d);
                this.lblTotal_Diseases.setText("Total enfermedades registradas: " + totalEnfermedades());
                this.jtfDisease.setText(null);
            } else {
                Object[] m = {"Favor digitar el nombre de la enfermedad\n" + "si no tiene enfermedad escribir: Ninguna"};
                JOptionPane.showMessageDialog(this, m, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void eventActionListenerBtnSave() {
        this.btnSave.addActionListener(actionEvent -> {
            if (!isEmpty()) {
                controller.addPatient(new Patient(this.jtfID.getText(), this.jtfName.getText(), returnEnfermedad()));
                this.enfermedad = null;
                this.enfermedad = new HashMap<>();
                this.lblTotal_Diseases.setText("Total enfermedades registradas: " + totalEnfermedades());
                this.lblTotal_Patients.setText("Total Pacientes: " + controller.totalPatients());
                cleanFields();
                this.jtfDisease.setText("Ninguna");
            } else {
                Object[] m = {"Favor llenar los campos"};
                JOptionPane.showMessageDialog(this, m, "Error", JOptionPane.ERROR_MESSAGE);
            }
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
        this.lblTotal_Diseases.setText("Total enfermedades registradas: " + totalEnfermedades());
        this.lblTotal_Patients.setText("Total Pacientes: " + controller.totalPatients());
        this.jtfDisease.setText("Ninguna");
    }
}
