package dbAccessInterface;

import model.Student;

import java.sql.Connection;
import java.util.ArrayList;

public interface StudentDBI {

    void setConnection(Connection connection);
    ArrayList<Student> getStudents();

}
