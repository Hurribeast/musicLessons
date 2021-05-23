package dbAccess;

import dbAccessInterface.TeacherDBI;
import exception.ConnectionException;
import model.Instrument;
import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDB implements TeacherDBI {
    private Connection connection;
    public TeacherDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());

    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Teacher> getTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();

        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select * from music_lessons.Teacher");
            ResultSet result = sqlRequest.executeQuery();

            while (result.next()){

                teachers.add(
                        new Teacher(
                                result.getInt("teacher_id"),
                                result.getString("first_name"),
                                result.getString("last_name"),
                                result.getDate("birthdate"),
                                result.getString("email"),
                                result.getString("phone_number")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return teachers;
    }

    public int getNbTeachers() {
        int nbTeachers = 0;
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select count(*) from music_lessons.Teacher");
            ResultSet result = sqlRequest.executeQuery();

            while(result.next()) {
                nbTeachers = result.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  nbTeachers;
    }

    public Teacher getTeacher(Integer teacherFK) {
        Teacher teacher = null;
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select * from music_lessons.Teacher where teacher_id = ?");
            sqlRequest.setInt(1,teacherFK);
            ResultSet result = sqlRequest.executeQuery();
            while(result.next()) {
                teacher = new Teacher(
                        result.getInt("teacher_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getDate("birthdate"),
                        result.getString("email"),
                        result.getString("phone_number"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return teacher;
    }
    public ArrayList<Teacher> getTeachersNameAndSurname() {
        ArrayList<Teacher> teachersName = new ArrayList<>();
        try {
            String sqlQuery = "SELECT last_name, first_name, teacher_id FROM teacher";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet results = preparedStatement.executeQuery(sqlQuery);

            while(results.next()) {
                teachersName.add(new Teacher(results.getString("last_name"), results.getString("first_name"), results.getInt("teacher_id")));
            }
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
        return teachersName;
    }

}
