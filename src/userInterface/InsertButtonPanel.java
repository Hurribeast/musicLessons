package userInterface;

import business.LessonBusiness;
import controller.Control;
import exception.ConnectionException;
import exception.DescriptionException;
import model.Lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertButtonPanel extends JPanel {
    JButton cancelButton,validateButton;
    MainWindow mainWindow;
    InsertForm insertForm;
    public InsertButtonPanel(MainWindow mainWindow,InsertForm insertForm){
        this.mainWindow = mainWindow;
        this.insertForm = insertForm;
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelListener());
        validateButton = new JButton("Confirm");
        validateButton.addActionListener(new ValidationListener());


        this.setLayout(new FlowLayout());
        this.add(cancelButton);
        this.add(validateButton);
    }

    private class ValidationListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            try {
                Lesson lesson = new Lesson(insertForm.getDateField(),insertForm.getIsNightClassField(),insertForm.getRoomNumberField(),insertForm.getMinuteDurationField(),insertForm.getDescriptionField(),insertForm.getCommentaryField(),insertForm.getGoalDescriptionField(),insertForm.getPriceField());
                new Control().addNewLesson(lesson);
            } catch (ConnectionException e) {
                e.printStackTrace();
            }
            catch (DescriptionException e) {
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
