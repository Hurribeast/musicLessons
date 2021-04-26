package dbAccess;

import exception.ConnectionException;
import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDB {

    private Connection connection;

    public TeacherDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
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
