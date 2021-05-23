package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InactivityTimeJFrame extends JFrame {
    private Container timeContainer;
    private InactivityTimePanel panel;

    public InactivityTimeJFrame() {
        super("Inactivity time");
        setBounds(0, 0, 500, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.panel = new InactivityTimePanel();
        this.timeContainer = this.getContentPane();
        this.timeContainer.add(panel);
        setVisible(true);
    }

    public InactivityTimePanel getPanel() {
        return this.panel;
    }

}
