package userInterface;

import model.LessonsBetweenDates;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class LessonsBetweenDatesJTableModel extends AbstractTableModel {

    private ArrayList<String> columnsNames;
    private ArrayList<LessonsBetweenDates> data;

    public LessonsBetweenDatesJTableModel(ArrayList<LessonsBetweenDates> data) {
        this.data = data;
        this.columnsNames = new ArrayList<>();
        this.columnsNames.add("ID");
        this.columnsNames.add("Date");
        this.columnsNames.add("Description");
        this.columnsNames.add("Instrument");
        this.columnsNames.add("I_height");
        this.columnsNames.add("I_width");
        this.columnsNames.add("I_weight");
        this.columnsNames.add("I_category");
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
        LessonsBetweenDates value = data.get(rowIndex);
        switch(colIndex) {
            case 0 : return value.getId();
            case 1 : return value.getDate();
            case 2 : return value.getDescription();
            case 3 : return value.getInstrumentName();
            case 4 : return value.getHeightMax();
            case 5 : return value.getWidthMax();
            case 6 : return value.getWeightMax();
            case 7 : return value.getCategoryName();
        }
        return null;
    }

    public Class getColumnClass(int index) {
        switch(index) {
            case 0 : return Integer.class;
            case 1 : return GregorianCalendar.class;
            case 4 : case 5 : case 6 : return Double.class;
            default : return String.class;
        }
    }
}
