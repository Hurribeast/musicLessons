package userInterface;

import javax.swing.*;
import java.awt.*;

public class LessonsBetweenDatesPanel extends JPanel {

    final int NB_COLUMNS = 8;
    private String [][] data;
    private JScrollPane scrollPane;
    private JTable table;
    private String [] columnsNames;

    public LessonsBetweenDatesPanel(String [][] data) {
        this.data = data;
        setColumnNames();
        setLayout(new BorderLayout());
        table = new JTable(this.data, columnsNames);
        this.scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setColumnNames() {
        this.columnsNames = new String[NB_COLUMNS];
        this.columnsNames[0] = "ID";
        this.columnsNames[1] = "Date";
        this.columnsNames[2] = "Description";
        this.columnsNames[3] = "Instrument";
        this.columnsNames[4] = "I_height";
        this.columnsNames[5] = "I_width";
        this.columnsNames[6] = "I_weight";
        this.columnsNames[7] = "I_category";
    }
}
