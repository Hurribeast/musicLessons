package userInterface;

import controller.Control;
import exception.ConnectionException;
import model.Lesson;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeletePanel extends JPanel {
    private JLabel message;
    private JTable lessonTable;
    private DeleteButtonPanel deleteButtonPanel;
    private MainWindow mainWindow;
    private ArrayList<Lesson> lessons;
    private ModifyJTablePanel model;
    private JScrollPane scrollPane;
    public  DeletePanel(MainWindow mainWindow){
        try {
            this.mainWindow = mainWindow;
            lessons = getLessons();
            message = new JLabel("<html><h1>DeletePanel Contenu à changer</h1></html>");
            message.setHorizontalAlignment(SwingConstants.CENTER);
            model = new ModifyJTablePanel(lessons);
            lessonTable = new JTable(model);
            lessonTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane = new JScrollPane (lessonTable);
            deleteButtonPanel = new DeleteButtonPanel(mainWindow,lessonTable,lessons);
            this.setLayout(new BorderLayout());
            this.add(message, BorderLayout.NORTH);
            this.add(scrollPane,BorderLayout.CENTER);
            this.add(deleteButtonPanel,BorderLayout.SOUTH);
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Lesson> getLessons() throws ConnectionException {
        ArrayList<Lesson> lessons = new Control().getLessons();
        return lessons;
    }
}
