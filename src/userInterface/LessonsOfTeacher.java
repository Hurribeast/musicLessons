package userInterface;

import controller.LessonsOfTeacherController;
import controller.TeacherController;
import exception.ConnectionException;
import model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LessonsOfTeacher extends JPanel {

    private String [] names;
    private JComboBox<String> namesComboBox;
    private TeacherController teacherController;
    private JButton displayButton;
    private MainWindow window;
    private LessonsOfTeacherController controller;

    public LessonsOfTeacher(MainWindow window) throws ConnectionException {
        this.window = window;
        this.controller = new LessonsOfTeacherController();
        setLayout(new BorderLayout());
        this.teacherController = new TeacherController();
        this.names = setNames();
        this.namesComboBox = new JComboBox<>(names);
        this.namesComboBox.setMaximumRowCount(6);
        add(namesComboBox, BorderLayout.NORTH);
        this.displayButton = new JButton("Display lessons");
        this.displayButton.addActionListener(new ResearchListener());
        add(displayButton, BorderLayout.SOUTH);
        this.namesComboBox.setEnabled(true);

    }

    public String [] setNames() {
        ArrayList<Teacher> teachers = teacherController.getTeachersNameAndSurname();
        int iTeacher = 0;
        String [] names = new String [teachers.size()];
        for(Teacher t : teachers) {
            names[iTeacher] = t.getLastName() + " " + t.getFirstName();
            iTeacher++;
        }
        return names;
    }

    private class ResearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Container container = window.getContentPane();
            container.removeAll();
            container.add(new LessonsOfTeacherPanel(controller.getData(namesComboBox.getSelectedIndex() + 1)));
            container.repaint();
            window.setVisible(true);
        }
    }
}
