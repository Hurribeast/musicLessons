package model;

import exception.DescriptionException;
import java.util.GregorianCalendar;

public class Lesson {

    private Integer id;
    private GregorianCalendar date;
    private Boolean isNightClass;
    private Integer roomNumber;
    private Integer minutesDuration;
    private String description;
    private String commentary;
    private String goalDescription;
    private Double price;
    private Integer teacherFk;
    private Integer instrumentFk;

    public Lesson(GregorianCalendar date, Boolean isNightClass, Integer roomNumber, Integer minutesDuration, String description, String commentary, String goalDescription, Double price,Integer teacherFk,Integer instrumentFk) throws DescriptionException {
        setDate(date);
        setNightClass(isNightClass);
        setRoomNumber(roomNumber);
        setMinutesDuration(minutesDuration);
        setDescription(description);
        setCommentary(commentary);
        setGoalDescription(goalDescription);
        setPrice(price);
        setTeacherFk(teacherFk);
        setInstrumentFk(instrumentFk);
    }
    public Lesson(Integer id, GregorianCalendar date, Boolean isNightClass, Integer roomNumber, Integer minutesDuration, String description, String commentary, String goalDescription, Double price,Integer teacherFk,Integer instrumentFk) throws DescriptionException {
        setId(id);
        setDate(date);
        setNightClass(isNightClass);
        setRoomNumber(roomNumber);
        setMinutesDuration(minutesDuration);
        setDescription(description);
        setCommentary(commentary);
        setGoalDescription(goalDescription);
        setPrice(price);
        setTeacherFk(teacherFk);
        setInstrumentFk(instrumentFk);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setNightClass(Boolean nightClass) {
        isNightClass = nightClass;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setMinutesDuration(Integer minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public void setDescription(String description) throws DescriptionException {
        if(description.isBlank()){
            throw new DescriptionException(description);
        }
        else{
            this.description = description;
        }

    }

    public void setCommentary(String commentary) {
        if(commentary == null ||commentary.isBlank()){
            this.commentary = null;
        }
        else {
            this.commentary = commentary;
        }

    }

    public void setGoalDescription(String goalDescription ) {
        if( goalDescription == null ||

                goalDescription.isBlank()){
            this.goalDescription = null;
        }
        else {
            this.goalDescription = goalDescription;
        }
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTeacherFk(Integer teacherFk) {
        this.teacherFk = teacherFk;
    }

    public void setInstrumentFk(Integer instrumentFk) {
        this.instrumentFk = instrumentFk;
    }

    public Integer getId() {
        return id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public Boolean getNightClass() {
        return isNightClass;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getMinutesDuration() {
        return minutesDuration;
    }

    public String getDescription() {
        return description;
    }

    public String getCommentary() {
        return commentary;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getTeacherFk() {
        return teacherFk;
    }

    public Integer getInstrumentFk() {
        return instrumentFk;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "date=" + date +
                ", isNightClass=" + isNightClass +
                ", roomNumber=" + roomNumber +
                ", minutesDuration=" + minutesDuration +
                ", description='" + description + '\'' +
                ", commentary='" + commentary + '\'' +
                ", goalDescription='" + goalDescription + '\'' +
                ", price=" + price +
                ", teacherFk=" + teacherFk +
                ", instrumentFk=" + instrumentFk +
                '}';
    }
}
