package dbAccess;

import dbAccessInterface.StudentDBI;
import exception.ConnectionException;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDB implements StudentDBI {
    private Connection connection;
    public StudentDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());

    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select * from music_lessons.Student");
            ResultSet result = sqlRequest.executeQuery();

            while (result.next()){

                students.add(
                        new Student(
                                result.getInt("student_id"),
                                result.getString("first_name"),
                                result.getString("last_name"),
                                result.getDate("birthdate"),
                                result.getString("email"),
                                result.getString("phone_number")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }
}
