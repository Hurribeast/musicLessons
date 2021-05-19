package controller;


import business.InstrumentsOfTeacherBusiness;
import exception.ConnectionException;
import model.InstrumentsOfTeacherResearch;

import java.util.ArrayList;


public class InstrumentOfTeacherController {

    private InstrumentsOfTeacherBusiness instrumentsOfTeacherBusiness;

    public InstrumentOfTeacherController() {
        instrumentsOfTeacherBusiness = new InstrumentsOfTeacherBusiness();
    }

    public ArrayList<InstrumentsOfTeacherResearch> getData(String string) throws ConnectionException {
        return instrumentsOfTeacherBusiness.getInstruments(string);
    }
}
