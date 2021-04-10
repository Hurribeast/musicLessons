package dbAccess;

import exception.ConnectionException;

import java.sql.Connection;

public class CategoryDB {

    private Connection connection;
    public CategoryDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());

    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void getGategories() {
    }
}
