package business;

import dbAccess.LessonsOfTeacherDB;
import exception.ConnectionException;
import model.LessonsOfTeacher;

import java.util.ArrayList;

public class LessonsOfTeacherBusiness {

    private LessonsOfTeacherDB dbAccess;

    public LessonsOfTeacherBusiness() throws ConnectionException {
        this.dbAccess = new LessonsOfTeacherDB();
    }

    public ArrayList<LessonsOfTeacher> getData(Integer id) {
        return dbAccess.getLessonsOfTeacher(id);
    }

}
