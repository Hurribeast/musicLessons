package userInterface;

import javax.swing.*;
import java.awt.*;

public class PriceReductionPanel extends JPanel {
    private JLabel message;
    public PriceReductionPanel(MainWindow mainWindow) {
        message = new JLabel("<html><h1>Tache Metier</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.NORTH);
    }
}
