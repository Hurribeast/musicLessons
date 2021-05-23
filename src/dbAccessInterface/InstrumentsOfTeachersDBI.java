package dbAccessInterface;

import model.InstrumentsOfTeacherResearch;

import java.sql.Connection;
import java.util.ArrayList;

public interface InstrumentsOfTeachersDBI {

    void setConnection(Connection connection);
    ArrayList<InstrumentsOfTeacherResearch> getTeachersWhoMatchTheString(String string);
}
