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

    public ArrayList<model.LessonsOfTeacher> getLessonsOfTeacher(Integer teacherID) throws ConnectionException {
        ArrayList<model.LessonsOfTeacher> lessonsOfTeacher = new ArrayList<>();
        try {
            String sqlQuery = "SELECT l.lesson_date, i.instrument_name, s.last_name, s.first_name FROM lesson l, instrument i, student s, learn x WHERE l.teacher_fk = " + teacherID + " AND l.instrument_fk = i.instrument_id AND x.student_fk = s.student_id AND x.lesson_fk = l.lesson_id;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet results = preparedStatement.executeQuery(sqlQuery);
            while(results.next()) {
                lessonsOfTeacher.add(new model.LessonsOfTeacher(results.getDate("lesson_date"), results.getString("instrument_name"), results.getString("last_name"), results.getString("first_name")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return lessonsOfTeacher;
    }

}
