package userInterface;

import javax.swing.*;
import java.awt.*;

public class ListingPanel extends Panel {
    private JLabel message;
    public  ListingPanel(){
        message = new JLabel("<html><h1>ListingPanel Contenu à changer</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(message, BorderLayout.CENTER);
    }
}
