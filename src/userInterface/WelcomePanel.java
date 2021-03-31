package userInterface;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {
    private JLabel welcomeMessage;

    public WelcomePanel(){
        welcomeMessage = new JLabel("<html><h1>Welcome to your music lessons application</h1></html>");
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(welcomeMessage, BorderLayout.CENTER);
    }
}
