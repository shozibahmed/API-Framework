import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel2 {
    public static Map<String, Map<String, String>> getDataMap() throws IOException{

        Map<String,Map<String, String>>superMap=new HashMap<String, Map<String, String>>();
      Map<String,String> myMap= new HashMap<String, String>();
        File fi=new File("C:\\Users\\Yusuf Ahmed\\Desktop\\RestApi.xlsx");
        FileInputStream fis=new FileInputStream(fi);
        XSSFWorkbook wb= new XSSFWorkbook(fis);
       XSSFSheet sheet= wb.getSheet("book");
       int rowsSize= sheet.getLastRowNum();
       for(int i=1;i<rowsSize;i++)
       {
         XSSFRow row= sheet.getRow(i);
        String keyCell= row.getCell(0).getStringCellValue();
         int colNum=row.getLastCellNum();
           for(int j=1;j<colNum;j++)
           {
             String value=  row.getCell(j).getStringCellValue();
               myMap.put(keyCell,value);
           }
           superMap.put("MASTERDATA",myMap);

       }
       return superMap;

    }
    public static String getValue(String key) throws Exception
    {
       Map<String, String> myVal= getDataMap().get("MASTERDATA");
      String retValue= myVal.get(key);
      return retValue;

    }


    public static void main(String[] args) throws Exception {
        System.out.println(getValue("author"));
    }



}


