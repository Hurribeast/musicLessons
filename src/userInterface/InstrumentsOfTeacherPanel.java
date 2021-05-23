package userInterface;

import model.InstrumentsOfTeacherResearch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InstrumentsOfTeacherPanel extends JPanel {

    private InstrumentsOfTeacherJTableModel model;
    private JTable table;
    private JScrollPane sp;

    public InstrumentsOfTeacherPanel(ArrayList<InstrumentsOfTeacherResearch> data) {
        this.model = new InstrumentsOfTeacherJTableModel(data);
        this.table = new JTable(model);
        this.sp = new JScrollPane(table);
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);

    }
}
