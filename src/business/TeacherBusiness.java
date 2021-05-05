package business;

import dbAccess.InstrumentDB;
import dbAccess.TeacherDB;
import exception.ConnectionException;
import model.Instrument;
import dbAccess.TeacherDB;
import exception.ConnectionException;
import model.Teacher;

import java.util.ArrayList;

public class TeacherBusiness {

    private TeacherDB teacherDB;
    //private TeacherDB dbAccess;

    /*public TeacherBusiness() throws ConnectionException {
        setTeacher();
    }*/

    /*public void setTeacher() throws ConnectionException {
        teacherDB = new TeacherDB();
    }*/

    public ArrayList<Teacher> getTeachers() {
        return teacherDB.getTeachers();

    }

    public int getNbTeachers() {
        return teacherDB.getNbTeachers();
    }

    public Teacher getTeacher(Integer teacherFK) {
       return teacherDB.getTeacher(teacherFK);
    

    public TeacherBusiness() throws ConnectionException {
        this.teacherDB = new TeacherDB();
    }

    public ArrayList<Teacher> getTeachersNameAndSurname() {
        return teacherDB.getTeachersNameAndSurname();
    }
}
