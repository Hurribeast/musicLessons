package controller;

import business.LessonsOfTeacherBusiness;
import exception.ConnectionException;
import model.LessonsOfTeacher;

import java.util.ArrayList;

public class LessonsOfTeacherController {

    private LessonsOfTeacherBusiness business;

    public LessonsOfTeacherController() throws ConnectionException  {
        this.business = new LessonsOfTeacherBusiness();
    }

    public ArrayList<LessonsOfTeacher> getData(Integer id) {
        return business.getData(id);
    }

}
