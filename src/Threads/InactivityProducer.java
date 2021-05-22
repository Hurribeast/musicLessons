package Threads;

import userInterface.InactivityTimePanel;

public class InactivityProducer extends Thread {

    private InactivityCommonZone commonZone;
    private static int seconds = 0;
    private InactivityTimePanel panel;

    public InactivityProducer(InactivityCommonZone commonZone, InactivityTimePanel panel) {
        super("producer");
        this.commonZone = commonZone;
        this.panel = panel;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                panel.repaint();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            this.commonZone.setSeconds(++seconds);
        }
    }

    public void setSeconds(int s) {
        seconds = s;
    }
}
