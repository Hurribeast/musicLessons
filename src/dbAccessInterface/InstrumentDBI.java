package dbAccessInterface;

import model.Instrument;
import java.sql.Connection;
import java.util.ArrayList;

public interface InstrumentDBI {

    void setConnection(Connection connection);
    ArrayList<Instrument> getInstruments();
    int getNbInstruments();
    Integer getInstrumentId(String instrumentField);
    String getInstrumentName(Integer instrumentFk);
}
