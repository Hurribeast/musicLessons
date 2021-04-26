package userInterface;

import controller.LessonsOfTeacherController;
import exception.ConnectionException;

import javax.swing.*;
import java.awt.*;

public class LessonsOfTeacherPanel extends JPanel {

    final static int MAX_COL = 4;
    private String [][] data;
    private String [] columnsNames;
    private LessonsOfTeacherController controller;
    private Integer teacherID;
    private JTable table;
    private JScrollPane scrollPane;

    public LessonsOfTeacherPanel(Integer id) throws ConnectionException {
        this.teacherID = id;
        this.controller = new LessonsOfTeacherController();
        this.data = controller.getPreparedData(teacherID);
        setColumnsNames();
        table = new JTable(data, columnsNames);
        this.scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
    public void setColumnsNames() {
        this.columnsNames = new String[MAX_COL];
        this.columnsNames[0] = "Date";
        this.columnsNames[1] = "Instrument";
        this.columnsNames[2] = "Nom élève";
        this.columnsNames[3] = "Prénom élève";
    }
}
