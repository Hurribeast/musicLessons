package controller;


import business.CategoryBusiness;
import business.LessonBusiness;
import exception.ConnectionException;
import model.Lesson;

public class Control {
    private LessonBusiness lessonBusiness;
    private CategoryBusiness categoryBusiness;



    public Control() throws ConnectionException {
        setLessonBusiness();
        setCategoryBusiness();
    }



    public void setLessonBusiness() throws ConnectionException {
        lessonBusiness = new LessonBusiness();
    }
    public void setCategoryBusiness() throws ConnectionException {
        categoryBusiness = new CategoryBusiness();
    }
    public void addNewLesson(Lesson lesson) {
        lessonBusiness.addNewLesson(lesson);
    }

    public String [] getCategoriesString() {

        return categoryBusiness.getCategoriesString();
    }
}
