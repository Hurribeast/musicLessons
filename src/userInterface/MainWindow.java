package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu lesson,research;
    private JMenuItem insert,modify,delete,firstResearch,secondResearch,thirdResearch,listing ;
    private JPanel welcomePanel;
    private Container container;

    public MainWindow(){

        super("Music Lessons");
        setBounds(100,100,700,500);
        addWindowListener (new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //Création de la JMenuBar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        //Création de l'onglet Lessons
        lesson = new JMenu("Lessons");
        insert = new JMenuItem("Insert");
        insert.addActionListener(new InsertListener());
        modify = new JMenuItem("Modify");
        modify.addActionListener(new ModifyListener());
        delete = new JMenuItem("Delete");
        delete.addActionListener(new DeleteListener());
        lesson.add(insert);
        lesson.add(modify);
        lesson.add(delete);
        menuBar.add(lesson);

        //Création de l'onglet Research
        research = new JMenu("Research");
        firstResearch = new JMenuItem("First Research");
        firstResearch.addActionListener(new FirstResearchListener());
        secondResearch = new JMenuItem("Second Research");
        secondResearch.addActionListener(new SecondResearchListener());
        thirdResearch = new JMenuItem("Third Research");
        thirdResearch.addActionListener(new ThirdResearchListener());
        research.add(firstResearch);
        research.add(secondResearch);
        research.add(thirdResearch);
        menuBar.add(research);

        //Création de l'onglet Listing
        listing = new JMenuItem("Listing");
        listing.addActionListener(new ListingListener());
        menuBar.add(listing);

        //Initialisation du container
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        //Création et ajout du panneaux d'accueil
        welcomePanel = new WelcomePanel();
        container.add(welcomePanel,BorderLayout.CENTER);

        setVisible(true);
    }

    private class InsertListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            container.add(new InsertPanel());
            container.repaint();
            MainWindow.this.setVisible(true);
        }
    }
    private class ModifyListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            container.add(new ModifyPanel());
            container.repaint();
            MainWindow.this.setVisible(true);
        }
    }
    private class DeleteListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            container.add(new DeletePanel());
            container.repaint();
            MainWindow.this.setVisible(true);
        }
    }

    private class FirstResearchListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            container.add(new FirstResearchPanel());
            container.repaint();
            MainWindow.this.setVisible(true);
        }
    }
    private class SecondResearchListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            container.add(new SecondResearchPanel());
            container.repaint();
            MainWindow.this.setVisible(true);
        }
    }
    private class ThirdResearchListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            container.add(new ThirdResearchPanel());
            container.repaint();
            MainWindow.this.setVisible(true);
        }
    }

    private class ListingListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            container.add(new ListingPanel());
            container.repaint();
            MainWindow.this.setVisible(true);
        }
    }



}