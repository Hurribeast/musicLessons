package dbAccessInterface;

import model.LessonsOfTeacher;

import java.sql.Connection;
import java.util.ArrayList;

public interface LessonsOfTeacherDBI {
    void setConnection(Connection connection);
    ArrayList<LessonsOfTeacher> getLessonsOfTeacher(Integer teacherID);
}
