package dbAccess;

import dbAccessInterface.InstrumentDBI;
import exception.ConnectionException;
import model.Instrument;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstrumentDB implements InstrumentDBI {

    private Connection connection;
    public InstrumentDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());

    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Instrument> getInstruments() {
        ArrayList<Instrument> instruments = new ArrayList<>();

        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select * from music_lessons.instrument");
            ResultSet result = sqlRequest.executeQuery();

            while (result.next()){
                instruments.add(
                        new Instrument(
                                result.getDouble("height_max"),
                                result.getDouble("width_max"),
                                result.getDouble("weight_max"),
                                result.getString("instrument_name"),
                                result.getString("description_instrument")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return instruments;
    }

    public int getNbInstruments() {
        int nbInstrument = 0;
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select count(*) from music_lessons.Instrument");
            ResultSet result = sqlRequest.executeQuery();

            while(result.next()) {
                nbInstrument = result.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  nbInstrument;
    }

    public Integer getInstrumentId(String instrumentField) {

        Integer instrumentId = null;
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select instrument_id from music_lessons.Instrument where instrument_name = ?");
            sqlRequest.setString(1,instrumentField);

            ResultSet result = sqlRequest.executeQuery();
            while(result.next()) {
                instrumentId = result.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return instrumentId;
    }

    public String getInstrumentName(Integer instrumentFk) {
        String instrumentName = null;
        try {
            PreparedStatement sqlRequest = connection.prepareStatement("select instrument_name from music_lessons.Instrument where instrument_id = ?");
            sqlRequest.setInt(1,instrumentFk);
            ResultSet result = sqlRequest.executeQuery();
            while(result.next()) {
                instrumentName = result.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return instrumentName;
    }
}
