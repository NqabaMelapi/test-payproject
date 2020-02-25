package utilities;

import jxl.Sheet;
import jxl.Workbook;


import java.io.File;
import java.util.Hashtable;

/** Retrieves and generate test data
 */
public class DataSheet {

    Workbook workbook;
    Sheet personalDetails;
    Sheet kinDetails;
    public Hashtable testData;

    /**Initialises data file path.
     *
     * @param workBookPath
     */
    public DataSheet(String workBookPath) {
        try {
            workbook = Workbook.getWorkbook(new File(workBookPath));

            personalDetails = workbook.getSheet("PersonalDetails");
            kinDetails = workbook.getSheet("kinDetails");

            testData = new Hashtable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**Reads data from a sheet and populate it to a hastable
     *
     */
    public void SetTestData() {
        for(int i = 0; i < personalDetails.getColumns(); i++) {
            testData.put(personalDetails.getCell(i, 0).getContents(), personalDetails.getCell(i,1).getContents());
        }

        for(int i = 0; i < kinDetails.getColumns(); i++) {
                testData.put(kinDetails.getCell(i, 0).getContents(), kinDetails.getCell(i,1).getContents());
        }
    }
}