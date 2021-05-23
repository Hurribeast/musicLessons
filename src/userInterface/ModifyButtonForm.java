package userInterface;

import controller.Control;
import exception.ConnectionException;
import exception.DescriptionException;
import model.Lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyButtonForm extends JPanel {
    private JButton cancelButton,validateButton;
    private MainWindow mainWindow;
    private ModifyForm modifyForm;
    private Lesson lesson;
    public ModifyButtonForm(MainWindow mainWindow, ModifyForm modifyForm, Lesson lesson) {
        this.mainWindow = mainWindow;
        this.modifyForm = modifyForm;
        this.lesson = lesson;
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ModifyButtonForm.CancelListener());
        validateButton = new JButton("Confirm");
        validateButton.addActionListener(new ModifyButtonForm.ValidationListener());


        this.setLayout(new FlowLayout());
        this.add(cancelButton);
        this.add(validateButton);
    }

    private class ValidationListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            try {
                int choice =JOptionPane.showConfirmDialog(null,"Souhaitez vous vraiment modifier ce cours ?","Select an option",JOptionPane.YES_OPTION);
                if(choice == 0){
                    if(modifyForm.getDescriptionField().equals("")){
                        new JOptionPane().showConfirmDialog(null,"Attention, le champ description est vide","Select an option",JOptionPane.CLOSED_OPTION);
                    }
                    else{
                        Lesson newLesson = new Lesson(lesson.getId(), modifyForm.getDateField(),modifyForm.getIsNightClassField(),modifyForm.getRoomNumberField(),modifyForm.getMinuteDurationField(),modifyForm.getDescriptionField(),modifyForm.getCommentaryField(),modifyForm.getGoalDescriptionField(),modifyForm.getPriceField(),modifyForm.getTeacherField(),modifyForm.getInstrumentField());
                        new Control().modifyLesson(newLesson);
                    }

                }
                if(choice == 0){

                }

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
