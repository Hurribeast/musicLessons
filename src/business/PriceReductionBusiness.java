package business;


import dbAccess.PriceReductionDB;
import exception.ConnectionException;
import model.PriceReduction;

import java.util.ArrayList;

public class PriceReductionBusiness {
    PriceReductionDB priceReductionDB;
    public PriceReductionBusiness() throws ConnectionException {
       setPriceReductionDB();
    }

    public void setPriceReductionDB() throws ConnectionException {
        this.priceReductionDB = new PriceReductionDB();
    }

    public String PriceReductionDetail(Integer id) throws ConnectionException {
        StringBuilder sb = new StringBuilder("");
        sb.append("<html><p> Base price : ").append(getBasePrice(id)).append("€\n </p>");
        ArrayList<Integer> foreignKeys = getLessonsFk(id);
        PriceReduction priceReduction = null;
        double total = 0;
        double price = 0;
        String percent = "0";
        int nbParticipant =0;
        sb.append("<p></p><p>Lesson Price with Reduction : \n </p>").append("<p>");
        for (Integer foreignKey: foreignKeys) {
            priceReduction = getLessonsPriceAndNbParticipant(foreignKey);
            price = priceReduction.getPrice();
            nbParticipant = priceReduction.getNbParticipant();
            if(nbParticipant >=20 ){
                price = price * 0.8;
                percent = "20";
            }
            else{
                if(nbParticipant >=15){
                    price = price * 0.9;
                    percent = "10";
                }
                else{
                    if(nbParticipant >=3) {
                        price = price * 0.95;
                        percent = "5";
                    }
                }
            }
            total+=price;
            sb.append(priceReduction.getLesson()).append(" : ").append(nbParticipant).append(" participant(s) =  ").append(price).append("€ ").append("(-").append(percent).append("%)</p><p>");
        }

        sb.append("</p><p>Total lesson with first reduction : "). append( total).append("€</p>");
        int nbLessons = getNbLessons(id);

        if(nbLessons >= 20 ){
            total = total - 20;
        }
        else{
            if(nbLessons >= 15){
                total = total - 10;
            }
            else{
                if(nbLessons >= 10) {
                    total = total - 5;
                }
            }
        }
        sb.append("<p>Total lesson with second reduction : "). append( total).append("€</p> </html>");
        return sb.toString();
    }

    public double getBasePrice(Integer id){
        double price = priceReductionDB.getBasePrice(id);
        return price;
    }

    public int getNbLessons(Integer id){
        int nbLessons = priceReductionDB.getNbLessons(id);
        return nbLessons;
    }

    public ArrayList<Integer> getLessonsFk(Integer id){
        return priceReductionDB.getLessonsFk(id);
    }

    public PriceReduction getLessonsPriceAndNbParticipant(Integer foreignKey){
        return priceReductionDB.getLessonsPriceAndNbParticipant(foreignKey);
    }
}
