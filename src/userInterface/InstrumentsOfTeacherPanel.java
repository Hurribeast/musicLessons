package userInterface;

import javax.swing.*;
import java.awt.*;

public class InstrumentsOfTeacherPanel extends JPanel {

    final int NB_COLUMNS = 8;

    private JTable table;
    private JScrollPane scrollPane;
    private String [][] data;
    private String [] columnsNames;

    public InstrumentsOfTeacherPanel(String [][] data) {
        this.data = data;
        setColumnsNames();
        setLayout(new BorderLayout());
        table = new JTable(this.data, columnsNames);
        this.scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setColumnsNames() {
        this.columnsNames = new String[NB_COLUMNS];
        this.columnsNames[0] = "I_name";
        this.columnsNames[1] = "I_height";
        this.columnsNames[2] = "I_width";
        this.columnsNames[3] = "I_weight";
        this.columnsNames[4] = "I_category";
        this.columnsNames[5] = "T_name";
        this.columnsNames[6] = "T_surname";
        this.columnsNames[7] = "T_mail";
    }
}
