package controller;

import business.LessonsBetweenDatesBusiness;
import exception.ConnectionException;

import java.sql.Date;

public class LessonsBetweenDatesController {

    private LessonsBetweenDatesBusiness business;

    public String [][] getPreparedData(Date startingDate, Date endingDate) throws ConnectionException {
        business = new LessonsBetweenDatesBusiness();
        return business.preparedData(startingDate, endingDate);
    }

}
