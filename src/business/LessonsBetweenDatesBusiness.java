package business;

import dbAccess.LessonsBetweenDatesDB;
import exception.ConnectionException;
import model.LessonsBetweenDates;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LessonsBetweenDatesBusiness {

    final static int NB_COLUMNS = 8;
    private LessonsBetweenDatesDB dbAccess;

    public String [][] preparedData(Date startingDate, Date endingDate) throws ConnectionException {
        dbAccess = new LessonsBetweenDatesDB();
        ArrayList<LessonsBetweenDates> lessons = dbAccess.getLessons(startingDate, endingDate);
        String [][] data = new String [lessons.size()][NB_COLUMNS];
        int row = 0;
        int col = 0;
        for(LessonsBetweenDates l : lessons) {
            data[row][col] = String.valueOf(l.getId());
            col++;
            data[row][col] = new SimpleDateFormat("yyyy/MM/dd").format(l.getDate().getTimeInMillis());
            col++;
            data[row][col] = l.getDescription();
            col++;
            data[row][col] = l.getInstrumentName();
            col++;
            data[row][col] = String.valueOf(l.getHeightMax());
            col++;
            data[row][col] = String.valueOf(l.getWidthMax());
            col++;
            data[row][col] = String.valueOf(l.getWeightMax());
            col++;
            data[row][col] = l.getCategoryName();
            col = 0;
            row++;
        }
        return data;
    }

}
