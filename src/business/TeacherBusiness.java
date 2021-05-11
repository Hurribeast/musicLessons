package business;

import dbAccess.TeacherDB;
import exception.ConnectionException;
import model.Teacher;

import java.util.ArrayList;

public class TeacherBusiness {

    private TeacherDB teacherDB;

    public ArrayList<Teacher> getTeachers() {
        return teacherDB.getTeachers();

    }

    public int getNbTeachers() {
        return teacherDB.getNbTeachers();
    }

    public Teacher getTeacher(Integer teacherFK) {
        return teacherDB.getTeacher(teacherFK);
    }

    public TeacherBusiness() throws ConnectionException {
        this.teacherDB = new TeacherDB();
    }

    public ArrayList<Teacher> getTeachersNameAndSurname() {
        return teacherDB.getTeachersNameAndSurname();
    }
}
