package userInterface;

import model.LessonsOfTeacher;

import javax.swing.table.AbstractTableModel;
import java.sql.Date;
import java.util.ArrayList;

public class LessonsOfTeacherJTableModel extends AbstractTableModel {

    private ArrayList<LessonsOfTeacher> data;
    private ArrayList<String> columnsNames;

    public LessonsOfTeacherJTableModel(ArrayList<LessonsOfTeacher> data) {
        this.data = data;
        this.columnsNames = new ArrayList<>();
        this.columnsNames.add("Date");
        this.columnsNames.add("Instrument");
        this.columnsNames.add("Name");
        this.columnsNames.add("Surname");
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
        LessonsOfTeacher value = data.get(rowIndex);
        switch(colIndex) {
            case 0 :
                return value.getDate();
            case 1 :
                return value.getInstrumentName();
            case 2 :
                return value.getStudentLastName();
            case 3 :
                return value.getStudentFirstName();
        }
        return null;
    }

    public Class getColumnClass(int index) {
        if(index == 0) {
            return Date.class;
        }
        return String.class;
    }
}
