package business;

import dbAccess.InstrumentDB;
import exception.ConnectionException;
import model.Instrument;

import java.util.ArrayList;

public class InstrumentBusiness {
    private InstrumentDB instrumentDB;

    public InstrumentBusiness() throws ConnectionException {
        setCategory();
    }

    public void setCategory() throws ConnectionException {
        instrumentDB = new InstrumentDB();
    }

    public ArrayList<Instrument> getInstruments() {
        return instrumentDB.getInstruments();
    }

    public Integer getInstrumentsId(String instrumentField) {
        return instrumentDB.getInstrumentId(instrumentField);
    }

    public int getNbInstruments() {
        return instrumentDB.getNbInstruments();
    }

    public String getInstrumentName(Integer instrumentFk) {
        return instrumentDB.getInstrumentName(instrumentFk);
    }
}
