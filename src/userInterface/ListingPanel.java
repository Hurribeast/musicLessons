package userInterface;

import controller.Control;
import exception.ConnectionException;
import model.Lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListingPanel extends JPanel {
    private JLabel message;
    private JTable lessonTable;
    private MainWindow mainWindow;
    private ArrayList<Lesson> lessons;
    private JButton cancelButton;
    private ModifyJTablePanel model;
    private JScrollPane scrollPane;
    public  ListingPanel(MainWindow mainWindow){
        try {
            this.mainWindow = mainWindow;
            lessons = getLessons();
            message = new JLabel("<html><h1>ListingPanel Contenu à changer</h1></html>");
            message.setHorizontalAlignment(SwingConstants.CENTER);
            model = new ModifyJTablePanel(lessons);
            lessonTable = new JTable(model);
            lessonTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane = new JScrollPane (lessonTable);
            cancelButton = new JButton("Cancel");
            cancelButton.setLayout(new FlowLayout());
            cancelButton.addActionListener(new ListingPanel.CancelListener());
            this.setLayout(new BorderLayout());
            this.add(message, BorderLayout.NORTH);
            this.add(scrollPane,BorderLayout.CENTER);
            this.add(cancelButton,BorderLayout.SOUTH);
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Lesson> getLessons() throws ConnectionException {
        ArrayList<Lesson> lessons = new Control().getLessons();
        return lessons;
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
