package userInterface;

import exception.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu home,lesson,research,listing;
    private JMenuItem returnHome,insert,modify,delete,instrumentsOfTeacher,secondResearch,thirdResearch,goToListing;
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
        //Création de l'onglet Home
        home = new JMenu("Home");
        returnHome = new JMenuItem("Home");
        returnHome.addActionListener(new HomeListener());
        home.add(returnHome);
        menuBar.add(home);

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
        instrumentsOfTeacher = new JMenuItem("First Research");
        instrumentsOfTeacher.addActionListener(new InstrumentsOfTeacherListener());
        secondResearch = new JMenuItem("Second Research");
        secondResearch.addActionListener(new SecondResearchListener());
        thirdResearch = new JMenuItem("Third Research");
        thirdResearch.addActionListener(new ThirdResearchListener());
        research.add(instrumentsOfTeacher);
        research.add(secondResearch);
        research.add(thirdResearch);
        menuBar.add(research);

        //Création de l'onglet Listing
        listing = new JMenu("Listing");
        goToListing = new JMenuItem("Listing");
        goToListing.addActionListener(new ListingListener());
        listing.add(goToListing);
        menuBar.add(listing);



        //Initialisation du container
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        //Création et ajout du panneaux d'accueil
        welcomePanel = new WelcomePanel();
        container.add(welcomePanel,BorderLayout.CENTER);

        setVisible(true);
    }

    public MainWindow getWindow() {
        return this;
    }

    private class HomeListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            container.add(new WelcomePanel());
            container.repaint();
            MainWindow.this.setVisible(true);
        }
    }

    private class InsertListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            try {
                container.add(new InsertPanel(MainWindow.this));
            } catch (ConnectionException e) {
                e.printStackTrace();
            }
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

    private class InstrumentsOfTeacherListener implements ActionListener
    {   // Il faut ajouter la gestion de l'erreur de connexion içi
        public void actionPerformed (ActionEvent event)
        {
            container.removeAll();
            try {
                container.add(new InstrumentsOfTeacher(getWindow()));
            } catch(ConnectionException exception) {
                exception.printStackTrace();
            }

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