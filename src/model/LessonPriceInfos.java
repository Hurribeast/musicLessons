package model;

public class LessonPriceInfos {
    private Integer nbParticipant;
    private Double price;
    private String lesson;

    public LessonPriceInfos(Integer nbParticipant, Double price, String lesson) {
        this.nbParticipant = nbParticipant;
        this.price = price;
        this.lesson = lesson;
    }

    public Integer getNbParticipant() {
        return nbParticipant;
    }

    public Double getPrice() {
        return price;
    }

    public String getLesson() {
        return lesson;
    }
}
