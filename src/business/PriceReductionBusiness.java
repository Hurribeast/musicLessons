package business;


import dbAccess.PriceReductionDB;
import exception.ConnectionException;
import model.LessonPriceInfos;

import java.util.ArrayList;

public class PriceReductionBusiness {
    PriceReductionDB priceReductionDB;
    Integer id;
    Double basePrice,priceFirstReduction,priceSecondReduction;
    ArrayList<Integer> foreignKeys;
    ArrayList<LessonPriceInfos> lessonsPriceInfos,lessonsPriceReductionsInfos;

    public PriceReductionBusiness(Integer id) throws ConnectionException {
        setPriceReductionDB();
        setID(id);
        setBasePrice(id);
        setLessonsFk(id);
        setLessonsPriceInfos();
        setLessonsPriceReductionInfos();
        setPriceFirstReduction(lessonsPriceReductionsInfos);
        setPriceSecondReduction();
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
    public void setLessonsPriceInfos() {
        ArrayList<LessonPriceInfos> lessonsPriceInfos = new ArrayList<>();
        for (Integer foreignKey : foreignKeys) {
            lessonsPriceInfos.add(getLessonsPriceAndNbParticipant(foreignKey));
        }
        this.lessonsPriceInfos = lessonsPriceInfos;
    }
    public void setLessonsPriceReductionInfos() {
        ArrayList<LessonPriceInfos> lessonsPriceReductionInfos = new ArrayList<>();
        double priceWithReduction;
        double basePrice;
        for (LessonPriceInfos lessonPriceInfos : lessonsPriceInfos) {
            basePrice = lessonPriceInfos.getPrice();
            if (lessonPriceInfos.getNbParticipant() >= 5) {
                priceWithReduction = basePrice * 0.8;
            } else {
                if (lessonPriceInfos.getNbParticipant() >= 3) {
                    priceWithReduction = basePrice * 0.9;
                } else {
                    if (lessonPriceInfos.getNbParticipant() >= 2) {
                        priceWithReduction = basePrice * 0.5;
                    } else {
                        priceWithReduction = basePrice;
                    }
                }
            }
            lessonsPriceReductionInfos.add(new LessonPriceInfos(lessonPriceInfos.getNbParticipant(), priceWithReduction, lessonPriceInfos.getLesson()));
        }
        this.lessonsPriceReductionsInfos = lessonsPriceReductionInfos;
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

    public void setPriceFirstReduction(ArrayList<LessonPriceInfos> lessonsPriceInfos){
        double total = 0;
        for (LessonPriceInfos lessonPriceInfos : lessonsPriceInfos) {
            total += lessonPriceInfos.getPrice();
        }
        priceFirstReduction = total;
    }

    public void setPriceSecondReduction() {
        int nbLessons = getNbLessons(id);
        if (nbLessons >= 5) {
            priceSecondReduction = priceFirstReduction - 20;
        } else {
            if (nbLessons >= 3) {
                priceSecondReduction = priceFirstReduction - 10;
            } else {
                if (nbLessons >= 2) {
                    priceSecondReduction = priceFirstReduction - 5;
                }
                else {
                    priceSecondReduction = priceFirstReduction;
                }
            }
        }
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
        sb.append(buildStringPrice(lessonsPriceInfos));
        sb.append("<p></p><p>Lesson Price with first Reduction : \n </p>");
        sb.append(buildStringPrice(lessonsPriceReductionsInfos));
        sb.append("<p></p>");
        sb.append("<p>Total lesson with second reduction : ").append(priceSecondReduction).append("€</p> </html>");
        return sb.toString();
    }



}
