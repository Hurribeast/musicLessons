package userInterface;

import javax.swing.*;
import java.awt.*;

public class DeletePanel extends JPanel {
    private JLabel message;
    public  DeletePanel(){
        message = new JLabel("<html><h1>DeletePanel Contenu à changer</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.CENTER);

    }
}
