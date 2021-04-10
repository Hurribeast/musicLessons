package model;

import exception.DescriptionException;

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

    public Lesson(Date date, Boolean isNightClass, Integer roomNumber, Integer minutesDuration, String description, String commentary, String goalDescription, Double price) throws DescriptionException {
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

    public void setDescription(String description) throws DescriptionException {
        if(description.isEmpty()){
            throw new DescriptionException(description);
        }
        else{
            this.description = description;
        }

    }

    public void setCommentary(String commentary) {
        if(commentary.isEmpty()){
            this.commentary = null;
        }
        else{
            this.commentary = commentary;
        }
    }

    public void setGoalDescription(String goalDescription) {
        if(goalDescription.isEmpty()){
            this.goalDescription = null;
        }
        else{
            this.goalDescription = goalDescription;
        }
    }

    public void setPrice(Double price) {
        this.price = price;
    }



    public Date getDate() {
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
                '}';
    }
}
