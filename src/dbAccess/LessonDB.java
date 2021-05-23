package dbAccess;

import exception.ConnectionException;
import exception.DescriptionException;
import model.Instrument;
import model.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class LessonDB {

    private Connection connection;

    public LessonDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void addNewLesson(Lesson lesson) {
        System.out.println(lesson.getDate());
        try {
            boolean lessonExist = existingLesson(lesson);
            //Insertion du nouveau cours dans la DB
            if(!lessonExist){
                String sql= "insert into lesson (is_night_class,room_number,minutes_duration,lesson_description,commentary,lesson_date,goals_description,price,teacher_fk,instrument_fk)" +
                        "values(?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement statement=connection.prepareStatement(sql);


                statement.setBoolean(1,lesson.getNightClass());
                statement.setInt(2,lesson.getRoomNumber());
                statement.setInt(3,lesson.getMinutesDuration());
                statement.setString(4,lesson.getDescription());
                statement.setString(5,lesson.getCommentary());
                statement.setTimestamp(6,new java.sql.Timestamp(lesson.getDate().getTimeInMillis()));
                statement.setString(7,lesson.getGoalDescription());
                statement.setDouble(8,lesson.getPrice());
                statement.setInt(9, lesson.getTeacherFk());
                statement.setInt(10,lesson.getInstrumentFk());
                statement.executeUpdate();
            }
            else{
                System.out.println("Lesson Deja Existante");
            }

        }
        catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private boolean existingLesson(Lesson lesson) throws SQLException {
        String sql ="select count(*) \n" +
                        "from lesson \n" +
                        "where is_night_class= ? \n" +
                        "and room_number= ? \n" +
                        "and minutes_duration= ? \n" +
                        "and lesson_description= ? \n" +
                        "and lesson_date= ? \n" +
                        "and price= ? \n" +
                        "and teacher_fk= ? \n" +
                        "and instrument_fk= ? \n;";


        PreparedStatement existingLessonSql = connection.prepareStatement(sql);

        existingLessonSql.setBoolean(1,lesson.getNightClass());
        existingLessonSql.setInt(2,lesson.getRoomNumber());
        existingLessonSql.setInt(3,lesson.getMinutesDuration());
        existingLessonSql.setString(4,lesson.getDescription());
        existingLessonSql.setTimestamp(5,new java.sql.Timestamp(lesson.getDate().getTimeInMillis()));
        existingLessonSql.setDouble(6,lesson.getPrice());
        existingLessonSql.setInt(7,lesson.getTeacherFk());
        existingLessonSql.setInt(8,lesson.getInstrumentFk());


        ResultSet resultSearchExistingLesson = existingLessonSql.executeQuery();

        int i = 0;
        while(resultSearchExistingLesson.next()) {
            i = resultSearchExistingLesson.getInt(1);
        }

        return i>0;
    }

    public ArrayList<Lesson> getLessons() {
        ArrayList<Lesson> lessons = new ArrayList<>();

        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select * from music_lessons.lesson");
            ResultSet result = sqlRequest.executeQuery();

            while (result.next()){
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(result.getTimestamp("lesson_date"));
                lessons.add(
                        new Lesson(
                                result.getInt("lesson_id"),
                                gregorianCalendar,
                                result.getBoolean("is_night_class"),
                                result.getInt("room_number"),
                                result.getInt("minutes_duration"),
                                result.getString("lesson_description"),
                                result.getString("commentary"),
                                result.getString("goals_description"),
                                result.getDouble("price"),
                                result.getInt("teacher_fk"),
                                result.getInt("instrument_fk")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (DescriptionException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    public void modifyLesson(Lesson newLesson) {
        try {
            PreparedStatement statement = connection.prepareStatement("update music_lessons.lesson set is_night_class = ?,room_number = ?,minutes_duration = ?,lesson_description = ?,commentary = ?,lesson_date = ?,goals_description = ?,price = ?,teacher_fk = ?,instrument_fk = ? where lesson_id = ?");


            statement.setBoolean(1,newLesson.getNightClass());
            statement.setInt(2,newLesson.getRoomNumber());
            statement.setInt(3,newLesson.getMinutesDuration());
            statement.setString(4,newLesson.getDescription());
            statement.setString(5,newLesson.getCommentary());
            statement.setTimestamp(6,new java.sql.Timestamp(newLesson.getDate().getTimeInMillis()));
            statement.setString(7,newLesson.getGoalDescription());
            statement.setDouble(8,newLesson.getPrice());
            statement.setInt(9, newLesson.getTeacherFk());
            statement.setInt(10,newLesson.getInstrumentFk());
            statement.setInt(11,newLesson.getId());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteLesson(Lesson lesson) {
        try {
            System.out.println(lesson.getId());
            PreparedStatement statement = connection.prepareStatement("delete\n" +
                    "from music_lessons.learn\n" +
                    "where lesson_fk = ?;");
            statement.setInt(1,lesson.getId());
            statement.executeUpdate();
            statement = connection.prepareStatement("delete\n" +
                    "from music_lessons.lesson\n" +
                    "where lesson_id = ?;");
            statement.setInt(1,lesson.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
