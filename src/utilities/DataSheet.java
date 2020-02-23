package utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class DataSheet {

    Workbook workbook;
    Sheet workSheet;
    Hashtable testData;

    public DataSheet(String workBookPath) {
        try {
            workbook = Workbook.getWorkbook(new File(workBookPath));
            workSheet = workbook.getSheet("sheet1");
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
        for(int i = 0; i < workSheet.getColumns(); i++) {
            testData.put(workSheet.getCell(0, i).getContents(), workSheet.getCell(1,i).getContents());
        }
    }
}