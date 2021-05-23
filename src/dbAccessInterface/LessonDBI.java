package dbAccessInterface;

import model.Lesson;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LessonDBI {

    void setConnection(Connection connection);
    void addNewLesson(Lesson lesson);
    boolean existingLesson(Lesson lesson) throws SQLException;
    ArrayList<Lesson> getLessons();
    void modifyLesson(Lesson newLesson);
    void deleteLesson(Lesson lesson);
}
