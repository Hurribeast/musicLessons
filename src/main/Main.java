package main;

import userInterface.InactivityTimeJFrame;
import userInterface.MainWindow;

public class Main {
    public static void main(String[] args) {
        InactivityTimeJFrame inactivityFrame = new InactivityTimeJFrame();
        new MainWindow(inactivityFrame.getPanel());


    }
}
