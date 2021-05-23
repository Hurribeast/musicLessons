package userInterface;

import controller.Control;
import exception.ConnectionException;

import javax.swing.*;
import java.awt.*;

public class PriceReductionPanelResult extends JPanel {
    private JLabel message,reductionResume;
    private String reduction;
    public PriceReductionPanelResult(MainWindow mainWindow, int id) throws ConnectionException {
        this.setLayout(new BorderLayout());
        message = new JLabel("<html><h1>Tache Metier</h1></html>");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        reduction = new Control().priceReduction(id);
        reductionResume = new JLabel(reduction);
        reductionResume.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(message, BorderLayout.NORTH);
        this.add(reductionResume,BorderLayout.CENTER);
        //this.add(new JButton("Cancel"),BorderLayout.SOUTH);
    }
}
