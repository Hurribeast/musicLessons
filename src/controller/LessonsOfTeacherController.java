package controller;

import business.LessonsOfTeacherBusiness;
import exception.ConnectionException;

public class LessonsOfTeacherController {

    private LessonsOfTeacherBusiness business;

    public LessonsOfTeacherController() throws ConnectionException  {
        this.business = new LessonsOfTeacherBusiness();
    }

    public String [][] getPreparedData(Integer id) throws ConnectionException {
        return business.getPreparedData(id);
    }

}
