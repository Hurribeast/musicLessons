package userInterface;

import javax.swing.*;
import java.awt.*;

public class ModifyPanel extends JPanel {
    private JLabel message;
    public  ModifyPanel(){
        message = new JLabel("<html><h1>ModifyPanel Contenu à changer</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.CENTER);

    }
}
