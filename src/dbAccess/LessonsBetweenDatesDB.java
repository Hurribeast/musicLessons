package dbAccess;

import exception.ConnectionException;
import model.LessonsBetweenDates;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class LessonsBetweenDatesDB {

    private Connection connection;

    public LessonsBetweenDatesDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    public ArrayList<LessonsBetweenDates> getLessons(Date startingDate, Date endingDate) {

        ArrayList<LessonsBetweenDates> lessons = new ArrayList<>();
        Date lesson_date_SQL;

        int lesson_id;
        GregorianCalendar lesson_date = new GregorianCalendar();
        String lesson_description;
        String instrument_name;
        double height_max;
        double width_max;
        double weight_max;
        String category_name;

        try {
            String sqlQuery = "SELECT l.lesson_id, l.lesson_date, l.lesson_description, i.instrument_name, i.height_max, i.width_max, i.weight_max, c.category_name FROM lesson l, instrument i, category c WHERE l.instrument_fk = i.instrument_id AND i.category_fk = c.category_id AND l.lesson_date > ? AND l.lesson_date < ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setDate(1, startingDate);
            preparedStatement.setDate(2, endingDate);
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                lesson_id = results.getInt("lesson_id");
                lesson_date_SQL = results.getDate("lesson_date");
                lesson_date.setTime(lesson_date_SQL);
                lesson_description = results.getString("lesson_description");
                instrument_name = results.getString("instrument_name");
                height_max = results.getDouble("height_max");
                width_max = results.getDouble("width_max");
                weight_max = results.getDouble("weight_max");
                category_name = results.getString("category_name");
                lessons.add(new LessonsBetweenDates(lesson_id, lesson_date, lesson_description, instrument_name, height_max, width_max, weight_max, category_name));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }

}
