package dbAccess;


import exception.ConnectionException;
import model.InstrumentsOfTeacherResearch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstrumentsOfTeachersDB {
    private Connection connection;
    public InstrumentsOfTeachersDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<InstrumentsOfTeacherResearch> getTeachersWhoMatchTheString(String string) {
        ArrayList<InstrumentsOfTeacherResearch> queryResults = new ArrayList<>();
        try {
            String sqlQuery = "SELECT i.instrument_name, i.height_max, i.width_max, i.weight_max, c.category_name, t.last_name, t.first_name, t.email FROM instrument i, category c, teacher t, play p WHERE t.last_name LIKE '%" + string + "%' AND p.teacher_fk = t.teacher_id AND p.instrument_fk = i.instrument_id AND i.category_fk = c.category_id;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet results = preparedStatement.executeQuery(sqlQuery);

            while(results.next()) {
                queryResults.add(new InstrumentsOfTeacherResearch(
                        results.getString("instrument_name"),
                        results.getFloat("height_max"),
                        results.getFloat("width_max"),
                        results.getFloat("weight_max"),
                        results.getString("category_name"),
                        results.getString("last_name"),
                        results.getString("first_name"),
                        results.getString("email")
                ));
            }

        } catch(SQLException exception) {
            exception.printStackTrace();
        }
        return queryResults;
    }

}
