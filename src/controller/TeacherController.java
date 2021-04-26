package controller;

import business.TeacherBusiness;
import exception.ConnectionException;
import model.Teacher;

import java.util.ArrayList;

public class TeacherController {

    private TeacherBusiness teacherBusiness;

    public TeacherController() throws ConnectionException {
        this.teacherBusiness = new TeacherBusiness();
    }

    public ArrayList<Teacher> getTeachersNameAndSurname() {
        return teacherBusiness.getTeachersNameAndSurname();
    }
}
