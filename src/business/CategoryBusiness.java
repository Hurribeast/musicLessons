package business;

import dbAccess.CategoryDB;

import exception.ConnectionException;


public class CategoryBusiness {
    private CategoryDB category;
    public CategoryBusiness() throws ConnectionException {
        setCategory();
    }

    public void setCategory() throws ConnectionException {
        category = new CategoryDB();
    }

    public String[] getCategoriesString() {
        String [] aaa =  {"aaa","aaa","aaa"};
        return  aaa;
        //category.getCategories();
    }
}
