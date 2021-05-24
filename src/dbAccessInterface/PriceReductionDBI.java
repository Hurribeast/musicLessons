package dbAccessInterface;

import model.LessonPriceInfos;

import java.sql.Connection;
import java.util.ArrayList;

public interface PriceReductionDBI {

    void setConnection(Connection connection);
    double getBasePrice(Integer id);
    int getNbLessons(Integer id);
    ArrayList<Integer> getLessonsId(Integer id);
    ArrayList<Integer> getLessonsFk(Integer id);
    LessonPriceInfos getLessonsPriceAndNbParticipant(Integer lessonFk);
}