package userInterface;

import model.Lesson;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ModifyJTablePanel extends AbstractTableModel {
    private ArrayList<Lesson> lessons;
    private ArrayList<String> columnNames;

    public ModifyJTablePanel(ArrayList<Lesson> lessons){
        this.lessons = lessons;
        columnNames = new ArrayList<>();
        columnNames.add("Id");
        columnNames.add("Name");
        columnNames.add("Room Number");
        columnNames.add("Teacher");
        columnNames.add("Instrument");
        columnNames.add("Commentary");
        columnNames.add("Date");
        columnNames.add("Goals Description");
        columnNames.add("Is Night Class");
        columnNames.add("Price");
        columnNames.add("Minutes Duration");

    }

    @Override
    public int getRowCount() {
        return lessons.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }
    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lesson lesson = lessons.get(rowIndex);
        switch(columnIndex) {
            case 0 : return lesson.getId();
            case 1 : return lesson.getDescription();
            case 2: return lesson.getRoomNumber();
            case 3 : return lesson.getTeacherFk();
            case 4 : return lesson.getInstrumentFk();
            case 5: { if (lesson.getCommentary() != null)
                    return lesson.getCommentary();
                    else return null;
            }
            case 6 :
                SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm");
                String dateStr = format.format(lesson.getDate().getTime());
                return dateStr;
            case 7 : { if (lesson.getGoalDescription() != null)
                    return lesson.getGoalDescription();
                    else return null;
            }
            case 8: return lesson.getNightClass();
            case 9 : return lesson.getPrice();
            case 10 : return lesson.getMinutesDuration();

        }
        return null;
    }

    public Class getColumnClass (int column)
    { Class c;
        switch (column)
        {
            case 0: c = Integer.class;
                break;
            case 1: c = String.class;
                break;
            case 2: c = Integer.class;
                break;
            case 3: c = Integer.class;
                break;
            case 4: c = Integer.class;
                break;
            case 5: c = String.class;
                break;
            case 6: c = String.class;
                break;
            case 7: c = String.class;
                break;
            case 8: c = Boolean.class;
                break;
            case 9: c = Double.class;
                break;
            case 10: c = Integer.class;
                break;
                default: c = String.class;
        }
        return c;
    }
}
