package utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import models.PersonalDetailsModel;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class DataSheet {

    Workbook workbook;
    Sheet personalDetails;
    Sheet kinDetails;
    public Hashtable testData;
    PersonalDetailsModel personalDetailsModel;

    public DataSheet(String workBookPath) {
        try {
            workbook = Workbook.getWorkbook(new File(workBookPath));
            personalDetailsModel = new PersonalDetailsModel();

            personalDetails = workbook.getSheet("PersonalDetails");
            kinDetails = workbook.getSheet("kinDetails");

            testData = new Hashtable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String GetTestData(String key) {
        String data = null;
        try {
            data = testData.get(key).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

//    public int GetRowCount(){
//        return workSheet.getRows();
//    }

//    public int GetColumnCount(){
//        return workSheet.getColumns();
//    }

    public void SetTestData() {
        for(int i = 0; i < personalDetails.getColumns(); i++) {
            testData.put(personalDetails.getCell(i, 0).getContents(), personalDetails.getCell(i,1).getContents());
        }

        for(int i = 0; i < kinDetails.getColumns(); i++) {
                testData.put(kinDetails.getCell(i, 0).getContents(), kinDetails.getCell(i,1).getContents());
        }
    }
}