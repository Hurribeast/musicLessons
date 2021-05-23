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
    private JButton cancelButton,validateButton;
    private MainWindow mainWindow;
    private InsertForm insertForm;
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
                int choice =JOptionPane.showConfirmDialog(null,"Souhaitez vous vraiment insérer ce cours ?","Select an option",JOptionPane.YES_OPTION);
                if(choice == 0){
                    if(insertForm.getDescriptionField().getText().equals("")){
                        new JOptionPane().showConfirmDialog(null,"Attention, le champ description est vide","Select an option",JOptionPane.CLOSED_OPTION);
                       // System.out.println("le field de description est vide");
                    }
                    else{
                        Lesson lesson = new Lesson(insertForm.getDateFieldValue(),insertForm.getIsNightClassFieldValue(),insertForm.getRoomNumberFieldValue(),insertForm.getMinuteDurationFieldValue(),insertForm.getDescriptionFieldValue(),insertForm.getCommentaryFieldValue(),insertForm.getGoalDescriptionFieldValue(),insertForm.getPriceFieldValue(),insertForm.getTeacherFieldValue(),insertForm.getInstrumentFieldValue());
                        new Control().addNewLesson(lesson);
                    }

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
