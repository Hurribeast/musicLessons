package model;

public class InstrumentsOfTeacherResearch {

    private String instrumentName;
    private double instrumentHeightMax;
    private double instrumentWidthMax;
    private double instrumentWeightMax;
    private String categoryName;
    private String teacherLastName;
    private String teacherFirstName;
    private String teacherEmail;

    public InstrumentsOfTeacherResearch(String instrumentName, double instrumentHeightMax, double instrumentWidthMax, double instrumentWeightMax, String categoryName, String teacherLastName, String teacherFirstName, String teacherEmail) {
        setInstrumentName(instrumentName);
        setInstrumentHeightMax(instrumentHeightMax);
        setInstrumentWidthMax(instrumentWidthMax);
        setInstrumentWeightMax(instrumentWeightMax);
        setCategoryName(categoryName);
        setTeacherLastName(teacherLastName);
        setTeacherFirstName(teacherFirstName);
        setTeacherEmail(teacherEmail);
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public void setInstrumentHeightMax(double instrumentHeightMax) {
        this.instrumentHeightMax = instrumentHeightMax;
    }


    public void setInstrumentWidthMax(double instrumentWidthMax) {
        this.instrumentWidthMax = instrumentWidthMax;
    }


    public void setInstrumentWeightMax(double instrumentWeightMax) {
        this.instrumentWeightMax = instrumentWeightMax;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }


    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public double getInstrumentHeightMax() {
        return instrumentHeightMax;
    }

    public double getInstrumentWidthMax() {
        return instrumentWidthMax;
    }

    public double getInstrumentWeightMax() {
        return instrumentWeightMax;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }
}
