package business;

import dbAccess.LessonDB;
import exception.ConnectionException;
import model.Lesson;


public class LessonBusiness {
    private LessonDB lesson;
    public LessonBusiness() throws ConnectionException {
        setLesson();
    }

    public void addNewLesson(Lesson lesson) {
        this.lesson.addNewLesson(lesson);
    }

    public void setLesson() throws ConnectionException {
        lesson = new LessonDB();
    }
}
