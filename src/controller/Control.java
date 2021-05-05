package controller;

import business.InstrumentBusiness;
import business.LessonBusiness;
import business.TeacherBusiness;
import exception.ConnectionException;
import model.Instrument;
import model.Lesson;
import model.Teacher;

import java.util.ArrayList;

public class Control {
    private LessonBusiness lessonBusiness;
    private InstrumentBusiness instrumentBusiness;
    private TeacherBusiness teacherBusiness;



    public Control() throws ConnectionException {
        setLessonBusiness();
        setCategoryBusiness();
        setTeacherBusiness();
    }

    public String getInstrumentName(Integer instrumentFk) {
        return instrumentBusiness.getInstrumentName(instrumentFk);
    }


    public void setLessonBusiness() throws ConnectionException {
        lessonBusiness = new LessonBusiness();
    }
    public void setCategoryBusiness() throws ConnectionException {
        instrumentBusiness = new InstrumentBusiness();
    }
    public void setTeacherBusiness() throws ConnectionException {
        teacherBusiness = new TeacherBusiness();
    }
    public void addNewLesson(Lesson lesson) {
        lessonBusiness.addNewLesson(lesson);
    }

    public ArrayList<Instrument> getInstruments() {

        return instrumentBusiness.getInstruments();
    }

    public ArrayList<Teacher> getTeachers() {

        return teacherBusiness.getTeachers();
    }

    public ArrayList<Lesson> getLessons() {
        return lessonBusiness.getLessons();
    }

    public Integer getInstrumentsId(String instrumentField) {
        return instrumentBusiness.getInstrumentsId(instrumentField);
    }

    public int getNbInstruments() {
        return instrumentBusiness.getNbInstruments();
    }

    public int getNbTeachers() {
        return teacherBusiness.getNbTeachers();
    }

    public Teacher getTeacher(Integer teacherFK) {
        return teacherBusiness.getTeacher(teacherFK);
    }

    public void modifyLesson(Lesson newLesson) {
        lessonBusiness.modifyLesson(newLesson);
    }

    public void deleteLesson(Lesson lesson) {
        lessonBusiness.deleteLesson(lesson);
    }
}
