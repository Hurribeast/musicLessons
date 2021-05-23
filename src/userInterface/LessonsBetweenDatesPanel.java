package userInterface;

import model.LessonsBetweenDates;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LessonsBetweenDatesPanel extends JPanel {

    private JTable table;
    private JScrollPane sp;
    private LessonsBetweenDatesJTableModel model;

    public LessonsBetweenDatesPanel(ArrayList<LessonsBetweenDates> data) {
        setLayout(new BorderLayout());
        model = new LessonsBetweenDatesJTableModel(data);
        table = new JTable(model);
        sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);
    }
}
