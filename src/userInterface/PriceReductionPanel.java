package userInterface;

import controller.Control;
import exception.ConnectionException;
import model.Lesson;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PriceReductionPanel extends JPanel {
    private MainWindow mainWindow;
    private String [] studentsNamesAndId;
    private JLabel message,studentName;
    private JComboBox studentsCombobox;
    private ArrayList<Student> students;
    private JPanel buttonPanel,teacherPanel;
    private JButton validation,cancel;
    public PriceReductionPanel(MainWindow mainWindow) {
        try {

            this.mainWindow = mainWindow;
            message = new JLabel("<html><h1>Tache Metier</h1></html>");
            message.setHorizontalAlignment(SwingConstants.CENTER);

            students = getStudents();
            studentsNamesAndId = getStudentsNamesAndId();
            studentsCombobox = new JComboBox(studentsNamesAndId);
            studentName = new JLabel("Student name :");
            studentName.setHorizontalAlignment(SwingConstants.RIGHT);
            teacherPanel = new JPanel();
            teacherPanel.setLayout(new GridLayout(1,2,5,5));
            teacherPanel.add(studentName);
            teacherPanel.add(studentsCombobox);
            validation = new JButton("Confirm");
            validation.addActionListener(new ValidationListener());
            cancel = new JButton("Cancel");
            cancel.addActionListener(new CancelListener());
            buttonPanel = new JPanel();
            buttonPanel.add(cancel);
            buttonPanel.add(validation);


            this.setLayout(new BorderLayout());
            //this.add(message, BorderLayout.NORTH);
            this.add(teacherPanel,BorderLayout.NORTH);
            this.add(buttonPanel,BorderLayout.SOUTH);
        } catch (ConnectionException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Student> getStudents() throws ConnectionException {
        ArrayList<Student> students = new Control().getStudents();
        return students;
    }

    public String [] getStudentsNamesAndId(){
        String [] studentsName = new String[students.size()];
        int i = 0;
        for (Student student: students) {
            studentsName[i] = student.getNameAndId();
            i++;
        }
        return studentsName;
    }
    public Integer getID(){
        String id = (String) this.studentsCombobox.getSelectedItem();
        char[] chars = id.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            if (Character.isDigit(c)){
                sb.append(c);
            }
        }
        String idString = sb.toString();
        Integer idInt = Integer.parseInt(idString);
        return idInt;
    }
    private class ValidationListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            try {
                int id = getID();
                mainWindow.getContentPane().removeAll();
                mainWindow.getContentPane().add(new PriceReductionPanelResult(mainWindow, id));
                mainWindow.getContentPane().repaint();
                mainWindow.setVisible(true);
            } catch (ConnectionException e) {
                e.printStackTrace();
            }

        }
    }
    private class CancelListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            mainWindow.getContentPane().removeAll();
            mainWindow.getContentPane().add(new WelcomePanel());
            mainWindow.getContentPane().repaint();
            mainWindow.setVisible(true);
        }
    }
}
