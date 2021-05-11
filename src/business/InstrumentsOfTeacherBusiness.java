package business;

import dbAccess.InstrumentsOfTeachersDB;
import exception.ConnectionException;
import model.InstrumentsOfTeacherResearch;

import java.util.ArrayList;

public class InstrumentsOfTeacherBusiness {

    private final int NB_COLUMNS = 8;
    private InstrumentsOfTeachersDB dbAccess;

    public String [][] prepareData(String string) throws ConnectionException {
        dbAccess = new InstrumentsOfTeachersDB();
        ArrayList<InstrumentsOfTeacherResearch> results = dbAccess.getTeachersWhoMatchTheString(string);
        String [][] data = new String[results.size()][NB_COLUMNS];
        int row = 0;
        int col = 0;
        for(InstrumentsOfTeacherResearch r : results) {
            data[row][col] = r.getInstrumentName();
            col++;
            data[row][col] = String.valueOf(r.getInstrumentHeightMax());
            col++;
            data[row][col] = String.valueOf(r.getInstrumentWidthMax());
            col++;
            data[row][col] = String.valueOf(r.getInstrumentWeightMax());
            col++;
            data[row][col] = r.getCategoryName();
            col++;
            data[row][col] = r.getTeacherLastName();
            col++;
            data[row][col] = r.getTeacherFirstName();
            col++;
            data[row][col] = r.getTeacherEmail();
            col = 0;
            row++;
        }
        return data;
    }
}
