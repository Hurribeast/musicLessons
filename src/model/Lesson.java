package model;

import java.util.Date;

public class Lesson {

    private Date date;
    private Boolean isNightClass;
    private Integer roomNumber;
    private Integer minutesDuration;
    private String description;
    private String commentary;
    private String goalDescription;
    private Double price;

    public Lesson(Date date, Boolean isNightClass, Integer roomNumber, Integer minutesDuration, String description, String commentary, String goalDescription, Double price) {
        setDate(date);
        setNightClass(isNightClass);
        setRoomNumber(roomNumber);
        setMinutesDuration(minutesDuration);
        setDescription(description);
        setCommentary(commentary);
        setGoalDescription(goalDescription);
        setPrice(price);
    }

    public void setDate(Date date) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
