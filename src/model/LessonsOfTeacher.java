package model;

import java.util.Date;

public class LessonsOfTeacher {

    private Date date;
    private String instrumentName;
    private String studentLastName;
    private String studentFirstName;

    public LessonsOfTeacher(Date date, String instrumentName, String studentLastName, String studentFirstName) {
        this.date = date;
        this.instrumentName = instrumentName;
        this.studentLastName = studentLastName;
        this.studentFirstName = studentFirstName;
    }

    public Date getDate() {
        return date;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }
}
