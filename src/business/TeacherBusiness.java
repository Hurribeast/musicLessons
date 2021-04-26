package business;

import dbAccess.TeacherDB;
import exception.ConnectionException;
import model.Teacher;

import java.util.ArrayList;

public class TeacherBusiness {

    private TeacherDB dbAccess;

    public TeacherBusiness() throws ConnectionException {
        this.dbAccess = new TeacherDB();
    }

    public ArrayList<Teacher> getTeachersNameAndSurname() {
        return dbAccess.getTeachersNameAndSurname();
    }
}
