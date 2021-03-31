package userInterface;

import javax.swing.*;
import java.awt.*;

public class InsertPanel extends JPanel {
    private JLabel message;
    public  InsertPanel(){
        message = new JLabel("<html><h1>InsertPanel Contenu à changer</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.CENTER);

    }
}
