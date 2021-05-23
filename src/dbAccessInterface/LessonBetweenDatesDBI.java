package dbAccessInterface;

import model.LessonsBetweenDates;

import java.sql.*;
import java.util.ArrayList;


public interface LessonBetweenDatesDBI {

    void setConnection(Connection connection);
    ArrayList<LessonsBetweenDates> getLessons(Date startingDate, Date endingDate);
}
