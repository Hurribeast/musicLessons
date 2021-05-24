package userInterface;

import controller.LessonsBetweenDatesController;
import exception.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class LessonsBetweenDates extends JPanel {

    private JSpinner startingDate, endingDate;
    private SpinnerDateModel spinnerStartingDateModel, spinnerEndingDateModel;
    private JSpinner.DateEditor startingDateEditor, endingDateEditor;
    private JButton research;
    private JLabel startingDateLabel, endingDateLabel, title;
    private MainWindow window;
    private JPanel contentPanel, buttonPanel;

    public LessonsBetweenDates(MainWindow window){
        this.window = window;
        this.startingDate = new JSpinner();
        this.endingDate = new JSpinner();
        this.title = new JLabel("<html><h1>Third research : Night lessons between two dates</h1></html>");
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.spinnerStartingDateModel = new SpinnerDateModel();
        this.spinnerEndingDateModel = new SpinnerDateModel();
        this.startingDate.setModel(this.spinnerStartingDateModel);
        this.endingDate.setModel(this.spinnerEndingDateModel);
        this.startingDateEditor = new JSpinner.DateEditor(startingDate, "dd-MM-yyyy");
        this.startingDate.setEditor(startingDateEditor);
        this.endingDateEditor = new JSpinner.DateEditor(endingDate, "dd-MM-yyyy");
        this.endingDate.setEditor(endingDateEditor);
        this.research = new JButton("Research");
        this.startingDateLabel = new JLabel("Starting date : ");
        this.endingDateLabel = new JLabel("Ending date : ");
        this.startingDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.endingDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.research.addActionListener(new ResearchListener());
        this.contentPanel = new JPanel();
        this.buttonPanel = new JPanel();

        setLayout(new BorderLayout());
        this.buttonPanel.add(research);
        add(title, BorderLayout.NORTH);
        this.contentPanel.setLayout(new GridLayout(2, 2, 150, 150));
        this.contentPanel.add(startingDateLabel);
        this.contentPanel.add(startingDate);
        this.contentPanel.add(endingDateLabel);
        this.contentPanel.add(endingDate);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class ResearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String startingDateString = new SimpleDateFormat("yyyy/MM/dd").format(startingDate.getValue());
                Date startingDateUtil = new SimpleDateFormat("yyyy/MM/dd").parse(startingDateString);
                GregorianCalendar startingDateGregorian = new GregorianCalendar();
                startingDateGregorian.setTime(startingDateUtil);
                java.sql.Date startingDateSQL = new java.sql.Date(startingDateGregorian.getTimeInMillis());

                String endingDateString = new SimpleDateFormat("yyyy/MM/dd").format(endingDate.getValue());
                Date endingDateUtil = new SimpleDateFormat("yyyy/MM/dd").parse(endingDateString);
                GregorianCalendar endingDateGregorian = new GregorianCalendar();
                endingDateGregorian.setTime(endingDateUtil);
                java.sql.Date endingDateSQL = new java.sql.Date(endingDateGregorian.getTimeInMillis());

                LessonsBetweenDatesController controller = new LessonsBetweenDatesController();
                Container container = window.getContentPane();
                container.removeAll();
                container.add(new LessonsBetweenDatesPanel(controller.getData(startingDateSQL, endingDateSQL)));
                window.setVisible(true);
            } catch (ParseException | ConnectionException exception) {
                exception.printStackTrace();
            }
        }
    }
}
