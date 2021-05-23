package dbAccess;

import exception.ConnectionException;
import exception.DescriptionException;
import model.Lesson;
import model.PriceReduction;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PriceReductionDB {

    private Connection connection;

    public PriceReductionDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }



    public double getBasePrice(Integer id) {
        double basePrice =0;
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("SELECT Sum(price) \"basePrice\" \n" +
                    "FROM lesson le\n" +
                    "join learn l\n" +
                    "on le.lesson_id = l.lesson_fk\n" +
                    "where l.student_fk = ?;");

            sqlRequest.setInt(1,id);
            ResultSet result = sqlRequest.executeQuery();
            while (result.next()){
                basePrice= result.getDouble("basePrice");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return basePrice;

    }

    public int getNbLessons(Integer id) {
        int nbLessons =0;
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("SELECT count(*) \"nbLessons\"\n" +
                    "FROM music_lessons.learn\n" +
                    "where student_fk = ?;");

            sqlRequest.setInt(1,id);
            ResultSet result = sqlRequest.executeQuery();
            while (result.next()){
                nbLessons= result.getInt("nbLessons");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nbLessons;
    }

    public ArrayList<Integer> getLessonsId(Integer id){
        ArrayList<Integer> lessonsId= new ArrayList<>();
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("SELECT lesson_fk \n" +
                    "FROM music_lessons.learn\n" +
                    "where student_fk = ?;");

            sqlRequest.setInt(1,id);
            ResultSet result = sqlRequest.executeQuery();
            while (result.next()){
                lessonsId.add(result.getInt("lesson_fk"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lessonsId;
    }

    public ArrayList<Integer> getLessonsFk(Integer id) {
        ArrayList<Integer> lessonsFk = new ArrayList<>();
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select lesson_fk\n" +
                    "from learn\n" +
                    "where student_fk = ?;");

            sqlRequest.setInt(1,id);
            ResultSet result = sqlRequest.executeQuery();
            while (result.next()){
                lessonsFk.add(result.getInt("lesson_fk"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  lessonsFk;
    }


    public PriceReduction getLessonsPriceAndNbParticipant(Integer lessonFk) {
        PriceReduction priceReduction = null;
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select count(*)\"nbParticipants\",le.price,le.lesson_description\n" +
                    "from learn l\n" +
                    "join student s\n" +
                    "on l.student_fk = s.student_id\n" +
                    "join lesson le\n" +
                    "on le.lesson_id = l.lesson_fk\n" +
                    "where l.lesson_fk = ?;");

            sqlRequest.setInt(1,lessonFk);
            ResultSet result = sqlRequest.executeQuery();
            while (result.next()){
                priceReduction =new PriceReduction(result.getInt("nbParticipants"),
                        result.getDouble("price"),
                        result.getString("lesson_description"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  priceReduction;
    }
}
