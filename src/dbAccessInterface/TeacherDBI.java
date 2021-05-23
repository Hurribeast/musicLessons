package dbAccessInterface;

import model.Teacher;

import java.sql.Connection;
import java.util.ArrayList;

public interface TeacherDBI {
    void setConnection(Connection connection);

    ArrayList<Teacher> getTeachers();

    int getNbTeachers();

    Teacher getTeacher(Integer teacherFK);

    ArrayList<Teacher> getTeachersNameAndSurname();
}
