package userInterface;

import controller.Control;
import exception.ConnectionException;
import model.Lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteButtonPanel extends JPanel{
    JButton cancelButton,validateButton;
    MainWindow mainWindow;
    JTable table;
    ArrayList<Lesson> lessons;
    public DeleteButtonPanel(MainWindow mainWindow, JTable lessonTable, ArrayList<Lesson> lessons) {
        this.mainWindow = mainWindow;
        this.table = lessonTable;
        this.lessons = lessons;
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new DeleteButtonPanel.CancelListener());

        validateButton = new JButton("Confirm");
        validateButton.addActionListener(new DeleteButtonPanel.ValidationListener());

        this.setLayout(new FlowLayout());
        this.add(cancelButton);
        this.add(validateButton);
    }

    private class ValidationListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {

            try {
                int choice =JOptionPane.showConfirmDialog(null,"Souhaitez vous vraiment supprimer ce cours ?","Select an option",JOptionPane.YES_OPTION);
                if(choice == 0){
                    int rowSelected = table.getSelectedRow();
                    Lesson lesson = lessons.get(rowSelected);
                    new Control().deleteLesson(lesson);
                    mainWindow.getContentPane().removeAll();
                    mainWindow.getContentPane().add(new WelcomePanel());
                    mainWindow.getContentPane().repaint();
                    mainWindow.setVisible(true);
                }
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
