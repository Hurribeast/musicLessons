package userInterface;

import javax.swing.*;
import java.awt.*;

public class SecondResearchPanel extends JPanel {
    private JLabel message;
    public SecondResearchPanel(){
        message = new JLabel("<html><h1>SecondResearch Contenu à changer</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.CENTER);
    }
}
