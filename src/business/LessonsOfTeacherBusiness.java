package business;

import dbAccess.LessonsOfTeacherDB;
import exception.ConnectionException;
import model.LessonsOfTeacher;

import java.util.ArrayList;

public class LessonsOfTeacherBusiness {

    final static int MAX_COL = 4;
    private LessonsOfTeacherDB dbAccess;

    public LessonsOfTeacherBusiness() throws ConnectionException {
        this.dbAccess = new LessonsOfTeacherDB();
    }

    public String [][] getPreparedData(Integer id) throws ConnectionException {
        ArrayList<LessonsOfTeacher> results = dbAccess.getLessonsOfTeacher(id);
        String [][] data = new String [results.size()][MAX_COL];
        int row = 0;
        int col = 0;
        for(LessonsOfTeacher r : results) {
            data[row][col] = String.format("%1$tY-%1$tm-%1$td", r.getDate());
            col++;
            data[row][col] = r.getInstrumentName();
            col++;
            data[row][col] = r.getStudentLastName();
            col++;
            data[row][col] = r.getStudentFirstName();
            col = 0;
            row++;
        }
        return data;
    }

}
