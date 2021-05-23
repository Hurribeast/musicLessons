package main;

import userInterface.InactivityTimeJFrame;
import userInterface.MainWindow;

public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        InactivityTimeJFrame inactivityFrame = new InactivityTimeJFrame(mainWindow);
    }
}
