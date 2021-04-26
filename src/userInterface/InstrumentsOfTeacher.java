package userInterface;

import controller.InstrumentOfTeacherController;
import exception.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InstrumentsOfTeacher extends JPanel {

    private JPanel nameOfTheTeacherPanel, buttonPanel;
    private JTextField nameOfTheTeacher;
    private JButton research;
    private InstrumentOfTeacherController controller;
    private MainWindow mainWindow;

    public InstrumentsOfTeacher(MainWindow mainWindow) throws ConnectionException {
        this.setLayout(new BorderLayout());
        this.mainWindow = mainWindow;
        this.controller = new InstrumentOfTeacherController();
        nameOfTheTeacherPanel = new JPanel();
        buttonPanel = new JPanel();
        nameOfTheTeacher = new JTextField("Name of the teacher here");
        nameOfTheTeacher.setHorizontalAlignment(SwingConstants.CENTER);
        nameOfTheTeacherPanel.add(nameOfTheTeacher);
        research = new JButton("Research");
        research.setHorizontalAlignment(SwingConstants.CENTER);
        research.addActionListener(new ResearchListener());
        buttonPanel.add(research);
        this.add(nameOfTheTeacherPanel, BorderLayout.NORTH);
        this.add(research, BorderLayout.SOUTH);
    }

    private class ResearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Container container = mainWindow.getContentPane();
                container.removeAll();
                container.add(new InstrumentsOfTeacherPanel(controller.getData(nameOfTheTeacher.getText())));
                container.repaint();
                mainWindow.setVisible(true);
            } catch(ConnectionException exception) {
                exception.printStackTrace();
            }

        }
    }
}
