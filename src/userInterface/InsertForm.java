package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertForm extends JPanel {
        private JLabel description, roomNumber,date,minuteDuration,price,isNightClass,commentary,goalDescription ;
        private JTextField descriptionField,priceField;
        private JTextArea commentaryField,goalDescriptionField;
        private JSpinner roomNumberField,dateField,minuteDurationField;
        private JCheckBox isNightClassField;
        private MainWindow mainWindow;

        public InsertForm(MainWindow mainWindow){
                this.mainWindow = mainWindow;
                //Init des JLabel
                description = new JLabel("Description :");
                description.setHorizontalAlignment(SwingConstants.RIGHT);
                roomNumber = new JLabel("Room Number :");
                roomNumber.setHorizontalAlignment(SwingConstants.RIGHT);
                date = new JLabel("Date :");
                date.setHorizontalAlignment(SwingConstants.RIGHT);
                minuteDuration = new JLabel("Duration (minutes) :");
                minuteDuration.setHorizontalAlignment(SwingConstants.RIGHT);
                price = new JLabel("Price :");
                price.setHorizontalAlignment(SwingConstants.RIGHT);
                isNightClass = new JLabel("Night Class :");
                isNightClass.setHorizontalAlignment(SwingConstants.RIGHT);
                commentary = new JLabel("Commentary :");
                commentary.setHorizontalAlignment(SwingConstants.RIGHT);
                goalDescription = new JLabel("Goal Description :");
                goalDescription.setHorizontalAlignment(SwingConstants.RIGHT);

                //Init des champs
                descriptionField = new JTextField();
                roomNumberField = new JSpinner();

                dateField = new JSpinner();
                SpinnerDateModel model = new SpinnerDateModel();
                dateField.setModel(model);
                JSpinner.DateEditor editor = new JSpinner.DateEditor(dateField, "dd-MM-yyyy");
                dateField.setEditor(editor);

                minuteDurationField = new JSpinner();
                priceField = new JTextField();
                isNightClassField = new JCheckBox();
                commentaryField = new JTextArea();
                goalDescriptionField = new JTextArea();

                //Set du GridLayout
                this.setLayout(new GridLayout(8,2,5,5));
                //Ajout des champs au GridLayout
                this.add(description);
                this.add(descriptionField);
                this.add(roomNumber);
                this.add(roomNumberField);
                this.add(date);
                this.add(dateField);
                this.add(minuteDuration);
                this.add(minuteDurationField);
                this.add(price);
                this.add(priceField);
                this.add(isNightClass);
                this.add(isNightClassField);
                this.add(commentary);
                this.add(new JScrollPane(commentaryField));
                this.add(goalDescription);
                this.add(new JScrollPane(goalDescriptionField));

        }
        public String getDescriptionField() {
                return descriptionField.getText();
        }
        // ATTENTION ON NE PEUT PAS RENTER DE TEXTE
        public Double getPriceField() {
                String price = priceField.getText();
                return Double.parseDouble(price);
        }
        public String getCommentaryField() {
                return commentaryField.getText();
        }
        public String getGoalDescriptionField() {
                return goalDescriptionField.getText();
        }
        public Integer getRoomNumberField() {
                return (Integer) roomNumberField.getValue();
        }
        public Date getDateField() {
                return (Date) dateField.getValue() ;
        }
        public Integer getMinuteDurationField() {
                return (Integer) minuteDurationField.getValue();
        }
        public Boolean getIsNightClassField() {
                return isNightClassField.isSelected();
        }
}
