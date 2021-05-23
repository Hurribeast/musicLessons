package controller;

import business.*;
import exception.ConnectionException;
import model.Instrument;
import model.Lesson;
import model.Student;
import model.Teacher;

import java.util.ArrayList;

public class Control {
    private LessonBusiness lessonBusiness;
    private InstrumentBusiness instrumentBusiness;
    private TeacherBusiness teacherBusiness;
    private CategoryBusiness categoryBusiness;
    private StudentBusiness studentBusiness;
    private PriceReductionBusiness priceReductionBusiness;



    public Control() throws ConnectionException {
        setLessonBusiness();
        setInstrumentBusiness();
        setTeacherBusiness();
        setCategoryBusiness();
        setStudentBusiness();
        setPriceReductionBusiness();
    }

    public String getInstrumentName(Integer instrumentFk) {
        return instrumentBusiness.getInstrumentName(instrumentFk);
    }


    public void setLessonBusiness() throws ConnectionException {
        lessonBusiness = new LessonBusiness();
    }
    public void setInstrumentBusiness() throws ConnectionException {
        instrumentBusiness = new InstrumentBusiness();
    }
    public void setCategoryBusiness() throws ConnectionException {
        categoryBusiness = new CategoryBusiness();
    }
    public void setTeacherBusiness() throws ConnectionException {
        teacherBusiness = new TeacherBusiness();
    }
    public void setStudentBusiness() throws ConnectionException {
        studentBusiness = new StudentBusiness();
    }
    public void setPriceReductionBusiness() throws ConnectionException {
        this.priceReductionBusiness = new PriceReductionBusiness();
    }

    public String priceReduction(Integer id) throws ConnectionException {
        return priceReductionBusiness.PriceReductionDetail(id);
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
    public String [] getCategoriesString() {
        return categoryBusiness.getCategoriesString();
    }

    public ArrayList<Student> getStudents() {
        return studentBusiness.getStudents();
    }
}
