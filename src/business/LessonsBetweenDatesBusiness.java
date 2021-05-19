package business;

import dbAccess.LessonsBetweenDatesDB;
import exception.ConnectionException;
import model.LessonsBetweenDates;

import java.sql.Date;
import java.util.ArrayList;

public class LessonsBetweenDatesBusiness {

    private LessonsBetweenDatesDB dbAccess;

    public LessonsBetweenDatesBusiness() throws ConnectionException {
        this.dbAccess = new LessonsBetweenDatesDB();
    }

    public ArrayList<LessonsBetweenDates> getData(Date startingDate, Date endingDate) {
        return dbAccess.getLessons(startingDate, endingDate);
    }

}
