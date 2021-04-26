package dbAccess;

import exception.ConnectionException;

import java.sql.*;

public class SingletonConnection {
    private static Connection connection;
    public static Connection getInstance() throws ConnectionException {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music_lessons",
                        "root",
                        "mgbvDYRH151198");
            }
            catch (SQLException exception) {
                throw new ConnectionException();
            }
        }
        return connection;
    }
}
