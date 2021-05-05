package business;

import dbAccess.LessonDB;
import exception.ConnectionException;
import model.Lesson;

import java.util.ArrayList;


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

    public ArrayList<Lesson> getLessons() {
        return lesson.getLessons();
    }

    public void modifyLesson(Lesson newLesson) {
        lesson.modifyLesson(newLesson);
    }

    public void deleteLesson(Lesson lesson) {
        this.lesson.deleteLesson(lesson);
    }
}
