package model;

import java.util.GregorianCalendar;

public class LessonsBetweenDates {
    private Integer id;
    private GregorianCalendar date;
    private String description;
    private String instrumentName;
    private double heightMax;
    private double widthMax;
    private double weightMax;
    private String categoryName;

    public LessonsBetweenDates(Integer id, GregorianCalendar date, String description, String instrumentName, double heightMax, double widthMax, double weightMax, String categoryName) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.instrumentName = instrumentName;
        this.heightMax = heightMax;
        this.widthMax = widthMax;
        this.weightMax = weightMax;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public double getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(double heightMax) {
        this.heightMax = heightMax;
    }

    public double getWidthMax() {
        return widthMax;
    }

    public void setWidthMax(double widthMax) {
        this.widthMax = widthMax;
    }

    public double getWeightMax() {
        return weightMax;
    }

    public void setWeightMax(double weightMax) {
        this.weightMax = weightMax;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
