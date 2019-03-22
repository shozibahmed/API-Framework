import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelToMapTemplate {
    final static String ExcelFile = "C:\\Users\\Yusuf Ahmed\\Desktop\\QA\\RestApi.xlsx";
    private static FileInputStream fis;
    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;
    //private static XSSFRow row;

    public static List<Map<String, String>> readExcel() throws Exception
    {
        File fl = new File(ExcelFile);
        fis = new FileInputStream(fl);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("TestData2");
        int rows = sheet.getLastRowNum();
        //Start from row 0
        XSSFRow row = sheet.getRow(0);

        List<Map<String, String>> alist = new ArrayList<Map<String, String>>();
        //start from top to button rows
        for (int i = 1; i < rows + 1; i++) {
            Map<String, String> map = new HashMap<String, String>();
            //start from left to right cell (coloumn)
            for (int j = 1; j < row.getLastCellNum(); j++) {
                Row column = CellUtil.getRow(0, sheet);
                Row r = CellUtil.getRow(i, sheet);
                String value = CellUtil.getCell(r, j).getStringCellValue();
                String key = CellUtil.getCell(column, j).getStringCellValue();


                // System.out.println(key);
                //System.out.println(value);
                map.put(key, value);
            }
            alist.add(map);
        }
        return alist;
    }

    public static void main(String[] args) throws Exception {
       // System.out.println(readExcel());
        for(Map<String,String> a: readExcel()){
            System.out.println(a);
        }
    }
}