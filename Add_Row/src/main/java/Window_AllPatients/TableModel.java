package Window_AllPatients;

import Logic.Disease;
import Logic.Patient;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Esteban
 * @created 09/04/2020 - 01:07 p. m.
 */
public class TableModel extends AbstractTableModel {
    ArrayList<Patient> patients;
    int[] cols;
    Object[] objects = new Object[60];

    public TableModel(int[] cols, ArrayList<Patient> patients) {
        this.patients = patients;
        this.cols = cols;
        initCols();
    }

    public TableModel() {
        patients = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPersonas(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public int getRowCount() {
        return patients.size();
    }

    public Patient getRowAt(int row) {
        return patients.get(row);
    }

    @Override
    public int getColumnCount() {
        return this.cols.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colsName[columnIndex];
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Patient p = patients.get(i);
        Disease d = new Disease();

        switch (cols[i1]) {
            case ID:
                return p.getId();
            case NOMBRE:
                return p.getNombre();
            case ENFERMEDAD: //Aqui es donde se de hacer aparecer una columna o fila para mostrar el array de efermedades
                /*for (Disease pa : p.getEnfermedades().values()) {
                    return pa.getNombre();
                }*/
                addValues(p.getEnfermedades(), i, i1);
                return objects[i];

            default:
                return "";
        }

    }

    @Override
    public void setValueAt(Object value, int row, int col) {

    }

    public void addValues(HashMap<String, Disease> list, int row, int col) {
        int i = 0;
        for (Disease d : list.values()) {
            objects[i] = d.getNombre();

            i++;
        }
        i = 0;
        this.fireTableRowsInserted(row, col);
    }

    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int ENFERMEDAD = 2;
    String[] colsName = new String[5];

    private void initCols() {
        colsName[ID] = "ID";
        colsName[NOMBRE] = "Nombre";
        colsName[ENFERMEDAD] = "Enfermedades Asociadas";
    }
}
