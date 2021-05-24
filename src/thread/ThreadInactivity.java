package thread;

import userInterface.InactivityTimePanel;
import userInterface.MainWindow;


public class ThreadInactivity extends Thread{
    private MainWindow mainWindow;
    private InactivityTimePanel inactivityTimePanel;
    public ThreadInactivity(MainWindow mainWindow, InactivityTimePanel inactivityTimePanel) {
        super("ThreadInactivity");
        this.mainWindow = mainWindow;
        this.inactivityTimePanel = inactivityTimePanel;
    }
    public void run(){
        while (true){
            try {
                if(mainWindow.getMouseEvent() !=null){
                    inactivityTimePanel.setSecondsToZero();
                    mainWindow.setMouseEventNull();
                }
                else{
                    inactivityTimePanel.setSeconds();
                }
                inactivityTimePanel.repaint();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
