package model;

import java.util.Date;

public class Instrument {
    private Double heightMax;
    private Double widthMax;
    private Double weightMax;
    private String name;
    private String description;



    public Instrument(Double heightMax, Double widthMax, Double weightMax, String name, String description) {
        setHeightMax(heightMax);
        setWidthMax(widthMax);
        setWeightMax(weightMax);
        setName(name);
        setDescription(description);
    }

    public void setHeightMax(Double heightMax) {
        this.heightMax = heightMax;
    }

    public void setWidthMax(Double widthMax) {
        this.widthMax = widthMax;
    }

    public void setWeightMax(Double weightMax) {
        this.weightMax = weightMax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHeightMax() {
        return heightMax;
    }

    public Double getWidthMax() {
        return widthMax;
    }

    public Double getWeightMax() {
        return weightMax;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
