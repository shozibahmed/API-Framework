import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelToMap {
    public static final String EXCELFILE_LOCATION = "C:\\Users\\Yusuf Ahmed\\Desktop\\QA\\RestApi.xlsx";
    private static FileInputStream fis;
    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;
    private static XSSFRow row;


    public static void loadExcl() throws Exception {

        File file = new File(EXCELFILE_LOCATION);
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("Sheet1");
        fis.close();

    }

    public static List<Map<String, String>> readAllData() throws Exception {
        if (sheet == null) {
            loadExcl();
        }
        List<Map<String, String>> mapList = new ArrayList();
        int rows = sheet.getLastRowNum();

        row = sheet.getRow(0);
        //it will run from left to right
        for (int j = 1; j < row.getLastCellNum(); j++) {
            Map<String, String> myMap = new HashMap<String, String>();
            // this loop will go from top to buttom
            for (int i = 1; i < rows+1 ; i++) {
                Row r = CellUtil.getRow(i, sheet);
                String key = CellUtil.getCell(r, 0).getStringCellValue();
                String value = CellUtil.getCell(r, j).getStringCellValue();
                myMap.put(key, value);

            }
            mapList.add(myMap);

        }
        return mapList;
    }


    public static void main(String[] args) throws Exception {

        System.out.println(readAllData());

    }
@Test
    public static void getValue( )throws Exception {




//        for (Map<String, String> m : readAllData()) {
//
//
//            System.out.println(m.get("Author"));





//        }



}


@Test
    public static void getMap(List<Map<String, String>> readAllData) {
        for (Map<String, String> m : readAllData) {
            System.out.println(m);
        }
}






}

