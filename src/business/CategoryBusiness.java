package business;

import dbAccess.CategoryDB;

import dbAccessInterface.CategoryDBI;
import exception.ConnectionException;


public class CategoryBusiness {
    private CategoryDBI category;

    public CategoryBusiness() throws ConnectionException {
        setCategory();
    }

    public void setCategory() throws ConnectionException {
        category = new CategoryDB();
    }
}
