package userInterface;

import javax.swing.*;
import java.awt.*;

public class ThirdResearchPanel extends JPanel {
    private JLabel message;
    public ThirdResearchPanel(){
        message = new JLabel("<html><h1>ThirdResearch Contenu à changer</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.CENTER);
    }
}
