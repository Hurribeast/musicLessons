package userInterface;

import model.LessonsOfTeacher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LessonsOfTeacherPanel extends JPanel {
    private JTable table;
    private JScrollPane sp;
    private LessonsOfTeacherJTableModel model;

    public LessonsOfTeacherPanel(ArrayList<LessonsOfTeacher> data) {
        setLayout(new BorderLayout());
        this.model = new LessonsOfTeacherJTableModel(data);
        this.table = new JTable(model);
        this.sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);
    }

}
