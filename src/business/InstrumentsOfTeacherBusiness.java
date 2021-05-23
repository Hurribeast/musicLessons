package business;

import dbAccess.InstrumentsOfTeachersDB;
import exception.ConnectionException;
import model.InstrumentsOfTeacherResearch;

import java.util.ArrayList;

public class InstrumentsOfTeacherBusiness {
    private InstrumentsOfTeachersDB dbAccess;

    public ArrayList<InstrumentsOfTeacherResearch> getInstruments(String string) throws ConnectionException {
        this.dbAccess = new InstrumentsOfTeachersDB();
        return dbAccess.getTeachersWhoMatchTheString(string);
    }

}
