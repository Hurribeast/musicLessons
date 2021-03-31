package userInterface;

import javax.swing.*;
import java.awt.*;


public class FirstResearchPanel extends JPanel {
    private JLabel message;
    public FirstResearchPanel(){
        message = new JLabel("<html><h1>FirstResearch Contenu à changer</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.CENTER);
    }
}
