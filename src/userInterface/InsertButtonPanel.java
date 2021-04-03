package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertButtonPanel extends JPanel {
    JButton cancelButton,validateButton;
    MainWindow mainWindow;
    public InsertButtonPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
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
