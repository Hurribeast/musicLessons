package userInterface;

import controller.InstrumentOfTeacherController;
import exception.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InstrumentsOfTeacher extends JPanel {

    private JTextField nameOfTheTeacher;
    private JButton research;
    private InstrumentOfTeacherController controller;
    private MainWindow mainWindow;
    private JLabel nameOfTheTeacherLabel, title;
    private JPanel teacherPanel, buttonPanel;

    public InstrumentsOfTeacher(MainWindow mainWindow) throws ConnectionException {
        this.setLayout(new BorderLayout());
        this.teacherPanel = new JPanel();
        this.title = new JLabel("<html><h1>First research : instruments of a teacher</h1></html>");
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        teacherPanel.setLayout(new GridBagLayout());
        this.buttonPanel = new JPanel();
        this.mainWindow = mainWindow;
        this.controller = new InstrumentOfTeacherController();
        this.nameOfTheTeacherLabel = new JLabel("Name of the teacher : ");
        nameOfTheTeacherLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nameOfTheTeacher = new JTextField("");
        nameOfTheTeacher.setPreferredSize(new Dimension(250, 20));

        research = new JButton("Research");
        research.setHorizontalAlignment(SwingConstants.CENTER);
        research.addActionListener(new ResearchListener());
        teacherPanel.add(nameOfTheTeacherLabel);
        teacherPanel.add(nameOfTheTeacher);
        buttonPanel.add(research);
        this.add(title, BorderLayout.NORTH);
        this.add(teacherPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
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
