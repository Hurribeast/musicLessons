package userInterface;

import model.InstrumentsOfTeacherResearch;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InstrumentsOfTeacherJTableModel extends AbstractTableModel {

    private ArrayList<String> columnsNames;
    private ArrayList<InstrumentsOfTeacherResearch> data;

    public InstrumentsOfTeacherJTableModel(ArrayList<InstrumentsOfTeacherResearch> data) {
        this.data = data;
        this.columnsNames = new ArrayList<>();
        this.columnsNames.add("I_Name");
        this.columnsNames.add("I_Height");
        this.columnsNames.add("I_Width");
        this.columnsNames.add("I_Weight");
        this.columnsNames.add("Category");
        this.columnsNames.add("T_Name");
        this.columnsNames.add("T_Surname");
        this.columnsNames.add("T_Mail");
    }

    public int getRowCount() {
        return this.data.size();
    }

    public int getColumnCount() {
        return this.columnsNames.size();
    }

    public String getColumnName(int index) {
        return this.columnsNames.get(index);
    }

    public Object getValueAt(int rowIndex, int colIndex) {
        InstrumentsOfTeacherResearch value = data.get(rowIndex);
        switch(colIndex) {
            case 0:
                return value.getInstrumentName();
            case 1:
                return value.getInstrumentHeightMax();
            case 2:
                return value.getInstrumentWidthMax();
            case 3:
                return value.getInstrumentWeightMax();
            case 4:
                return value.getCategoryName();
            case 5:
                return value.getTeacherLastName();
            case 6:
                return value.getTeacherFirstName();
            case 7:
                return value.getTeacherEmail();
        }
        return null;
    }

    public Class getColumnClass(int index) {
        Class c;
        switch(index) {
            case 1 : case 2 : case 3 : c = Double.class;
            break;
            default : c = String.class;
            break;
        }
        return c;
    }
}
