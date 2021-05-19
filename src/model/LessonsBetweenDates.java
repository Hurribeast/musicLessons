package model;

import java.util.GregorianCalendar;

public class LessonsBetweenDates {
    private Integer id;
    private GregorianCalendar date;
    private String description;
    private String instrumentName;
    private Double heightMax;
    private Double widthMax;
    private Double weightMax;
    private String categoryName;

    public LessonsBetweenDates(Integer id, GregorianCalendar date, String description, String instrumentName, Double heightMax, Double widthMax, Double weightMax, String categoryName) {
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

    public Double getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(Double heightMax) {
        this.heightMax = heightMax;
    }

    public Double getWidthMax() {
        return widthMax;
    }

    public void setWidthMax(Double widthMax) {
        this.widthMax = widthMax;
    }

    public Double getWeightMax() {
        return weightMax;
    }

    public void setWeightMax(Double weightMax) {
        this.weightMax = weightMax;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
