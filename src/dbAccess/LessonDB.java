package dbAccess;

import exception.ConnectionException;
import model.Lesson;

import java.sql.*;

public class LessonDB {

    private Connection connection;

    public LessonDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void addNewLesson(Lesson lesson) {
        try {
            String sql= "insert into lesson (is_night_class,room_number,minutes_duration,lesson_description,commentary,lesson_date,goals_description,price,teacher_fk,instrument_fk)" +
                    "values(?,?,?,?,?,?,?,?,?,?)";

            java.sql.Date sqlBirthdate = new java.sql.Date(lesson.getDate().getTime());

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1,lesson.getNightClass());
            statement.setInt(2,lesson.getRoomNumber());
            statement.setInt(3,lesson.getMinutesDuration());
            statement.setString(4,lesson.getDescription());
            statement.setString(5,lesson.getCommentary());
            statement.setDate(6, sqlBirthdate);
            statement.setString(7,lesson.getGoalDescription());
            statement.setDouble(8,lesson.getPrice());
            statement.setNull(9, Types.INTEGER);
            statement.setNull(10,Types.INTEGER);

            statement.executeUpdate();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
