package business;


import dbAccess.PriceReductionDB;
import exception.ConnectionException;
import model.LessonPriceInfos;

import java.util.ArrayList;

public class PriceReductionBusiness {
    PriceReductionDB priceReductionDB;
    Integer id;
    Double basePrice;
    ArrayList<Integer> foreignKeys;

    public PriceReductionBusiness(Integer id) throws ConnectionException {
        setPriceReductionDB();
        setID(id);
        setBasePrice(id);
        setLessonsFk(id);
    }

    public void setPriceReductionDB() throws ConnectionException {
        this.priceReductionDB = new PriceReductionDB();
    }
    public void setID(Integer id) {
        this.id = id;
    }
    public void setBasePrice(Integer id) {
        basePrice = priceReductionDB.getBasePrice(id);
    }
    public void setLessonsFk(Integer id) {
        foreignKeys = priceReductionDB.getLessonsFk(id);
    }


    public ArrayList<LessonPriceInfos> setLessonsPriceInfos(ArrayList<Integer> foreignKeys) {
        ArrayList<LessonPriceInfos> lessonsPriceInfos = new ArrayList<>();
        for (Integer foreignKey : foreignKeys) {
            lessonsPriceInfos.add(getLessonsPriceAndNbParticipant(foreignKey));
        }
        return lessonsPriceInfos;
    }
    public ArrayList<LessonPriceInfos> setLessonsPriceReductionInfos(ArrayList<LessonPriceInfos> lessonsPriceInfos) {
        ArrayList<LessonPriceInfos> lessonsPriceReductionInfos = new ArrayList<>();
        double priceWithReduction;
        double basePrice;
        for (LessonPriceInfos lessonPriceInfos : lessonsPriceInfos) {
            basePrice = lessonPriceInfos.getPrice();
            double reduction;
            if (lessonPriceInfos.getNbParticipant() >= 5) {
                reduction = 0.8;
            } else {
                if (lessonPriceInfos.getNbParticipant() >= 3) {
                    reduction = 0.9;
                } else {
                    if (lessonPriceInfos.getNbParticipant() >= 2) {
                        reduction = 0.95;
                    } else {
                        reduction = 1;
                    }
                }
            }
            priceWithReduction = calculateReduction(basePrice,reduction);

            lessonsPriceReductionInfos.add(new LessonPriceInfos(lessonPriceInfos.getNbParticipant(), priceWithReduction, lessonPriceInfos.getLesson()));
        }
        return lessonsPriceReductionInfos;
    }

    public double calculateReduction(double basePrice, double reduction) {
        return basePrice * reduction;
    }

    public String buildStringPrice(ArrayList<LessonPriceInfos> lessonsPriceInfos) {
        StringBuilder sb = new StringBuilder("");
        double total = 0;
        for (LessonPriceInfos lessonPriceInfos : lessonsPriceInfos) {
            total += lessonPriceInfos.getPrice();
            sb.append("<p>").append(lessonPriceInfos.getLesson()).append(" ").append(lessonPriceInfos.getPrice()).append("</p>");
        }
        sb.append("<p> TOTAL :").append(total).append("€ </p>");
        return sb.toString();
    }

    public double setPriceFirstReduction(ArrayList<LessonPriceInfos> lessonsPriceInfos){
        double total = 0;
        for (LessonPriceInfos lessonPriceInfos : lessonsPriceInfos) {
            total += lessonPriceInfos.getPrice();
        }
        return total;
    }

    public double setPriceSecondReduction(double priceFirstReduction, int nbLessons) {
        double priceSecondReduction;
        int reduction = 0;
        if (nbLessons >= 5) {
            reduction = 20;
        } else {
            if (nbLessons >= 3) {
                reduction = 10;
            } else {
                if (nbLessons >= 2) {
                    reduction = 5;
                }
            }
        }
        priceSecondReduction = secondReduction(priceFirstReduction,reduction);
        return priceSecondReduction;
    }

    public double secondReduction(double priceFirstReduction, int reduction) {
        return priceFirstReduction - reduction;
    }

    public int getNbLessons(Integer id){
        int nbLessons = priceReductionDB.getNbLessons(id);
        return nbLessons;
    }

    public LessonPriceInfos getLessonsPriceAndNbParticipant(Integer foreignKey){
        return priceReductionDB.getLessonsPriceAndNbParticipant(foreignKey);
    }

    public String PriceReductionDetail(){
        StringBuilder sb = new StringBuilder("");
        sb.append("<html><p> Price without reduction : ").append("</p>");
        ArrayList<LessonPriceInfos> lessonsPriceInfos = setLessonsPriceInfos(foreignKeys);
        sb.append(buildStringPrice(lessonsPriceInfos));
        sb.append("<p></p><p>Lesson Price with first Reduction : \n </p>");
        ArrayList<LessonPriceInfos> lessonsPriceReductionInfos =  setLessonsPriceReductionInfos(lessonsPriceInfos);
        sb.append(buildStringPrice(lessonsPriceReductionInfos));
        sb.append("<p></p>");
        int nbLessons = getNbLessons(id);
        double firstPriceReduction = setPriceFirstReduction(lessonsPriceReductionInfos);
        double priceSecondReduction =  setPriceSecondReduction(firstPriceReduction,nbLessons);
        sb.append("<p>Total lesson with second reduction : ").append(priceSecondReduction).append("€</p> </html>");
        return sb.toString();
    }
}
