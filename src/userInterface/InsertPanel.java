package userInterface;

import javax.swing.*;
import java.awt.*;

public class InsertPanel extends JPanel {
    private JLabel title;
    private MainWindow mainWindow;
    public  InsertPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        title = new JLabel("<html><h1>InsertPanel EN COURS</h1></html>");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);

        InsertForm insertForm = new InsertForm(mainWindow);
        this.add(insertForm, BorderLayout.CENTER);
        InsertButtonPanel insertButtonPanel = new InsertButtonPanel(mainWindow);
        this.add(insertButtonPanel,BorderLayout.SOUTH);
    }

}
