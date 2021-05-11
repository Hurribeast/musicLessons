package dbAccess;

import exception.ConnectionException;
import userInterface.LessonsOfTeacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LessonsOfTeacherDB {

    private Connection connection;

    public LessonsOfTeacherDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<model.LessonsOfTeacher> getLessonsOfTeacher(Integer teacherID) {
        ArrayList<model.LessonsOfTeacher> lessonsOfTeacher = new ArrayList<>();
        try {
            //String sqlQuery = "SELECT l.lesson_date, i.instrument_name, s.last_name, s.first_name FROM lesson l, instrument i, student s, learn x WHERE l.teacher_fk = " + teacherID + " AND l.instrument_fk = i.instrument_id AND x.student_fk = s.student_id AND x.lesson_fk = l.lesson_id;";
            String sqlQuery = "SELECT l.lesson_date, i.instrument_name, s.last_name, s.first_name FROM lesson l left join learn x on x.lesson_fk = l.lesson_id left join student s on x.student_fk = s.student_id join instrument i on i.instrument_id = l.instrument_fk WHERE l.teacher_fk = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,teacherID);
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                lessonsOfTeacher.add(new model.LessonsOfTeacher(results.getDate("lesson_date"), results.getString("instrument_name"), results.getString("last_name"), results.getString("first_name")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return lessonsOfTeacher;
    }

}
