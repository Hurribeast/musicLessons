package dbAccess;

import dbAccessInterface.CategoryDBI;
import exception.ConnectionException;

import java.sql.Connection;

public class CategoryDB implements CategoryDBI {

    private Connection connection;
    public CategoryDB() throws ConnectionException {
        setConnection(SingletonConnection.getInstance());

    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
