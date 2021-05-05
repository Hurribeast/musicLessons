package userInterface;

import controller.Control;
import exception.ConnectionException;
import model.Lesson;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ModifyPanel extends JPanel {
    private JLabel message;
    private JTable lessonTable;
    private ModifyButtonPanel modifyButtonPanel;
    private MainWindow mainWindow;
    private ArrayList<Lesson> lessons;
    
    public  ModifyPanel(MainWindow mainWindow){

        try {
            this.mainWindow = mainWindow;
            lessons = getLessons();
            message = new JLabel("<html><h1>ModifyPanel Contenu à changer</h1></html>");
            message.setHorizontalAlignment(SwingConstants.CENTER);
            ModifyJTablePanel model = new ModifyJTablePanel(lessons);
            lessonTable = new JTable(model);
            lessonTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane (lessonTable);
            modifyButtonPanel = new ModifyButtonPanel(mainWindow,lessonTable,lessons);
            this.setLayout(new BorderLayout());
            this.add(message, BorderLayout.NORTH);
            this.add(scrollPane,BorderLayout.CENTER);
            this.add(modifyButtonPanel,BorderLayout.SOUTH);
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Lesson> getLessons() throws ConnectionException {
        ArrayList<Lesson> lessons = new Control().getLessons();
        return lessons;
    }
}
