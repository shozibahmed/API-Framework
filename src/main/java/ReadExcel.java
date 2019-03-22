import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadExcel {


        public ArrayList<String> getData(String TestCaseName)throws IOException{

        ArrayList<String> a= new ArrayList<String>();
        FileInputStream fis= new FileInputStream("C:\\Users\\Yusuf Ahmed\\Desktop\\RestApi.xlsx");
        XSSFWorkbook workbook= new XSSFWorkbook(fis);
       int sheetNumber= workbook.getNumberOfSheets();
       for(int i=0;i<sheetNumber;i++)
       {
           if (workbook.getSheetName(i).equalsIgnoreCase("restdata"))
           {
              XSSFSheet sheet= workbook.getSheetAt(i);
             Iterator<Row> rows= sheet.iterator();
             Row  firstRow= rows.next();
             Iterator<Cell> ce= firstRow.cellIterator();
             int k=0;
             int column=0;

             while(ce.hasNext())

             {
                 Cell value=ce.next();
                if( value.getStringCellValue().equalsIgnoreCase("TestCaseName"))
                 {
                     column =k;


                 }
                 k++;
             }
               System.out.println(column+ "   test");
             while(rows.hasNext()){

                Row rs = rows.next();
                if(rs.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName)){


                   Iterator<Cell> cv= rs.cellIterator();
                   while(cv.hasNext()){
                       Cell c=cv.next();
                       if(c.getCellTypeEnum()== CellType.STRING) {
                           a.add(c.getStringCellValue());
                       }
                       else
                       {
                          a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

                       }
                   }

                }





             }



           }



       }


            return a;
        }




}
