package userInterface;

import exception.ConnectionException;
import model.Lesson;

import javax.swing.*;
import java.awt.*;

public class ModifyFormPanel extends JPanel {
    private JLabel title;
    private MainWindow mainWindow;

    public ModifyFormPanel(MainWindow mainWindow,Lesson lesson) throws ConnectionException {
        this.mainWindow = mainWindow;
        title = new JLabel("<html><h1>ModifiyFORM</h1></html>");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);

        ModifyForm modifyForm = new ModifyForm(lesson);
        this.add(modifyForm, BorderLayout.CENTER);
        ModifyButtonForm modifyButtonForm = new ModifyButtonForm(mainWindow, modifyForm,lesson);
        this.add(modifyButtonForm, BorderLayout.SOUTH);
    }
}
