package userInterface;

import controller.Control;
import exception.ConnectionException;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class InsertForm extends JPanel {
        private JLabel description, roomNumber,date,minuteDuration,price,isNightClass,commentary,goalDescription,category ;
        private JTextField descriptionField;
        private JTextArea commentaryField,goalDescriptionField;
        private JSpinner roomNumberField,dateField,minuteDurationField,priceField;
        private JCheckBox isNightClassField;
        private JComboBox categoryField;
        private String [] categories;
        private MainWindow mainWindow;

        public InsertForm(MainWindow mainWindow) throws ConnectionException {
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
                category = new JLabel("Teacher :");

                //Init des champs

                descriptionField = new JTextField();
                SpinnerModel modelRoomNumber = new SpinnerNumberModel(1, 1, 40, 1);
                roomNumberField = new JSpinner(modelRoomNumber);

                dateField = new JSpinner();
                SpinnerDateModel model = new SpinnerDateModel();
                dateField.setModel(model);
                JSpinner.DateEditor editor = new JSpinner.DateEditor(dateField, "dd-MM-yyyy");
                dateField.setEditor(editor);

                SpinnerModel modelDuration = new SpinnerNumberModel(60, 60, 240, 30);
                minuteDurationField = new JSpinner(modelDuration);
                SpinnerModel priceModel = new SpinnerNumberModel(0.00, 0.00, 200, 0.01);
                priceField = new JSpinner(priceModel);
                isNightClassField = new JCheckBox();
                commentaryField = new JTextArea();
                goalDescriptionField = new JTextArea();
                categories = getCategories();
                categoryField = new JComboBox();

                //Set du GridLayout
                this.setLayout(new GridLayout(9,2,5,5));
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
                this.add(category);
                this.add(categoryField);

        }
        public String getDescriptionField() {
                return descriptionField.getText();
        }
        public Double getPriceField() {
                return (Double) priceField.getValue();
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
        public String [] getCategories() throws ConnectionException {
                return new Control().getCategoriesString();
        }

}
