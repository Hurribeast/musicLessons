package userInterface;

import controller.Control;
import exception.ConnectionException;
import exception.DescriptionException;
import model.Lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyButtonPanel extends JPanel{

    JButton cancelButton,validateButton;
    MainWindow mainWindow;
    JTable table;
    ArrayList<Lesson> lessons;
    public ModifyButtonPanel(MainWindow mainWindow, JTable table, ArrayList<Lesson> lessons){
        this.mainWindow = mainWindow;
        this.table = table;
        this.lessons = lessons;
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ModifyButtonPanel.CancelListener());

        validateButton = new JButton("Confirm");
        validateButton.addActionListener(new ModifyButtonPanel.ValidationListener());

        this.setLayout(new FlowLayout());
        this.add(cancelButton);
        this.add(validateButton);
    }

    private class ValidationListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {

            try {
                int rowSelected = table.getSelectedRow();
                Lesson lesson = lessons.get(rowSelected);
                mainWindow.getContentPane().removeAll();
                mainWindow.getContentPane().add(new ModifyFormPanel(mainWindow,lesson));
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
