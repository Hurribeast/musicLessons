package model;

public class InstrumentsOfTeacherResearch {

    private String instrumentName;
    private Double instrumentHeightMax;
    private Double instrumentWidthMax;
    private Double instrumentWeightMax;
    private String categoryName;
    private String teacherLastName;
    private String teacherFirstName;
    private String teacherEmail;

    public InstrumentsOfTeacherResearch(String instrumentName, Double instrumentHeightMax, Double instrumentWidthMax, Double instrumentWeightMax, String categoryName, String teacherLastName, String teacherFirstName, String teacherEmail) {
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

    public void setInstrumentHeightMax(Double instrumentHeightMax) {
        this.instrumentHeightMax = instrumentHeightMax;
    }


    public void setInstrumentWidthMax(Double instrumentWidthMax) {
        this.instrumentWidthMax = instrumentWidthMax;
    }


    public void setInstrumentWeightMax(Double instrumentWeightMax) {
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

    public Double getInstrumentHeightMax() {
        return instrumentHeightMax;
    }

    public Double getInstrumentWidthMax() {
        return instrumentWidthMax;
    }

    public Double getInstrumentWeightMax() {
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
