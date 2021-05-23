package business;

import dbAccess.StudentDB;
import exception.ConnectionException;
import model.Student;

import java.util.ArrayList;

public class StudentBusiness {
    private StudentDB studentDB;
    public  StudentBusiness() throws ConnectionException {
        this.studentDB = new StudentDB();
    }

    public ArrayList<Student> getStudents() {
        return studentDB.getStudents();
    }
}
