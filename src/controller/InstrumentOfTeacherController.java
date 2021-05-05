package controller;


import business.InstrumentsOfTeacherBusiness;
import exception.ConnectionException;


public class InstrumentOfTeacherController {

    private InstrumentsOfTeacherBusiness instrumentsOfTeacherBusiness;

    public InstrumentOfTeacherController() {
        instrumentsOfTeacherBusiness = new InstrumentsOfTeacherBusiness();
    }

    public String [][] getData(String string) throws ConnectionException {
        return instrumentsOfTeacherBusiness.prepareData(string);
    }
}
