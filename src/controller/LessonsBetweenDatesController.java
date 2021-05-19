package controller;

import business.LessonsBetweenDatesBusiness;
import exception.ConnectionException;
import model.LessonsBetweenDates;

import java.sql.Date;
import java.util.ArrayList;

public class LessonsBetweenDatesController {

    private LessonsBetweenDatesBusiness business;

    public ArrayList<LessonsBetweenDates> getData(Date startingDate, Date endingDate) throws ConnectionException {
        business = new LessonsBetweenDatesBusiness();
        return business.getData(startingDate, endingDate);
    }

}
