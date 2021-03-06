package userInterface;

import controller.Control;
import exception.ConnectionException;
import model.Instrument;
import model.Lesson;
import model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ModifyForm extends JPanel {
    private JLabel description, roomNumber,date,minuteDuration,price,isNightClass,commentary,goalDescription,instrument,teacher ;
    private JTextField descriptionField;
    private JTextArea commentaryField,goalDescriptionField;
    private JSpinner roomNumberField,dateField,minuteDurationField,priceField;
    private JCheckBox isNightClassField;
    private JComboBox instrumentField,teacherField;
    private String[] instruments,teachers;
    private MainWindow mainWindow;

    public ModifyForm(Lesson lesson) throws ConnectionException {
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
        instrument = new JLabel("Instrument :");
        instrument.setHorizontalAlignment(SwingConstants.RIGHT);
        teacher = new JLabel("Teacher :");
        teacher.setHorizontalAlignment(SwingConstants.RIGHT);

        //Init des champs

        descriptionField = new JTextField();
        descriptionField.setText(lesson.getDescription());
        SpinnerModel modelRoomNumber = new SpinnerNumberModel(1, 1, 40, 1);
        roomNumberField = new JSpinner(modelRoomNumber);
        roomNumberField.setValue(lesson.getRoomNumber());

        dateField = new JSpinner();
        SpinnerDateModel model = new SpinnerDateModel();
        dateField.setModel(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateField, "dd-MM-yyyy kk:mm");
        dateField.setEditor(editor);
        dateField.setValue(lesson.getDate().getTime());


        SpinnerModel modelDuration = new SpinnerNumberModel(60, 60, 240, 30);
        minuteDurationField = new JSpinner(modelDuration);
        minuteDurationField.setValue(lesson.getMinutesDuration());
        SpinnerModel priceModel = new SpinnerNumberModel(0.00, 0.00, 200, 0.01);
        priceField = new JSpinner(priceModel);
        priceField.setValue(lesson.getPrice());
        isNightClassField = new JCheckBox();
        isNightClassField.setSelected(lesson.getNightClass());
        commentaryField = new JTextArea();
        commentaryField.setText(lesson.getCommentary());
        goalDescriptionField = new JTextArea();
        goalDescriptionField.setText(lesson.getGoalDescription());
        instruments = getInstrumentsString();
        instrumentField = new JComboBox(instruments);
        instrumentField.setSelectedItem(new Control().getInstrumentName(lesson.getInstrumentFk()));
        teachers = getTeachersString();
        teacherField = new JComboBox(teachers);
        teacherField.setSelectedItem(getTeacherString(lesson.getTeacherFk()));


        //Set du GridLayout
        this.setLayout(new GridLayout(10,2,5,5));
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
        this.add(instrument);
        this.add(instrumentField);
        this.add(teacher);
        this.add(teacherField);

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
    public GregorianCalendar getDateField() {
        System.out.println(dateField);
        GregorianCalendar gc = new GregorianCalendar();
        Date date = (Date) dateField.getValue();
        gc.setTime(date);
        return gc;
    }
    public Integer getMinuteDurationField() {
        return (Integer) minuteDurationField.getValue();
    }
    public Boolean getIsNightClassField() {
        return isNightClassField.isSelected();
    }
    public Integer getTeacherField(){
        String teacherField = (String) this.teacherField.getSelectedItem();
        char[] chars = teacherField.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            if (Character.isDigit(c)){
                sb.append(c);
            }
        }
        String idString = sb.toString();
        Integer id = Integer.parseInt(idString);
        return id;
    }

    public Integer getInstrumentField() throws ConnectionException {
        String instrumentField = (String)this.instrumentField.getSelectedItem();
        Integer instrumentId = new Control().getInstrumentsId(instrumentField);
        return instrumentId;
    }

    public String[] getInstrumentsString() throws ConnectionException {
        ArrayList<Instrument> instruments = new Control().getInstruments();
        int nbInstruments = new Control().getNbInstruments();
        String [] instrumentsName = new String[nbInstruments];
        int iInstrumentsName = 0;
        for (Instrument instrument : instruments) {
            instrumentsName[iInstrumentsName] = instrument.getName();
            iInstrumentsName++;
        }
        return instrumentsName;
    }
    public String[] getTeachersString() throws ConnectionException {
        ArrayList<Teacher> teachers = new Control().getTeachers();
        int nbTeachers = new Control().getNbTeachers();
        String [] teachersName = new String[nbTeachers];
        int iTeachersName = 0;
        for (Teacher teacher : teachers) {
            teachersName[iTeachersName] = teacher.getLastName() + " " + teacher.getFirstName() + " (" + teacher.getId() + ")";
            iTeachersName++;
        }
        return teachersName;
    }
    public String getTeacherString(Integer teacherFK) throws ConnectionException {
        Teacher teacher = new Control().getTeacher(teacherFK);
        String teacherName = teacher.getLastName() + " " + teacher.getFirstName() + " (" + teacher.getId() + ")";
        return teacherName;
    }

}
