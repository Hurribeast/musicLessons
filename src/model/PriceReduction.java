package model;

public class PriceReduction {
    private Integer nbParticipant;
    private Double price;
    private String lesson;

    public PriceReduction(Integer nbParticipant, Double price, String lesson) {
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
