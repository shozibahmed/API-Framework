import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadExcelData {


    public ArrayList<String> getExcelData(String excelPath, String sheetName, String columnName, String rowName) throws IOException {
        ArrayList<String> data= new ArrayList<String>();
// Accesing the folder by using FileInputStrem
        FileInputStream fis = new FileInputStream(excelPath);
        //accesing the excel sheets
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        // selecting the individual sheet by sheetiterator
        Iterator<Sheet> sheet = wb.sheetIterator();
        String cellData=null;
        while (sheet.hasNext()) {
            Sheet st = sheet.next();
            if (st.getSheetName().equalsIgnoreCase(sheetName)) {
                Iterator<Row> rows = st.iterator();
                //accessing the first row of a sheet
                Row firstrow = rows.next();
                Iterator<Cell> cell = firstrow.cellIterator();
                int k = 0;
                int column = 0;
                // move cell from left to right
                while (cell.hasNext()) {
                    if (cell.next().getStringCellValue().equalsIgnoreCase(columnName)) {
                        column = k;
                    }
                    k++;
                }
                //System.out.println(column);
                //moving row up to down
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(rowName)) {
                        Iterator<Cell> cl = r.iterator();
                        while (cl.hasNext()) {
                            Cell c = cl.next();
                            if (c.getCellTypeEnum() == CellType.STRING) {
                                cellData=c.getStringCellValue();

                                data.add(cellData);
                                //System.out.println(cellData);
                                //System.out.println(c.getStringCellValue());
                            } else {
                                cellData =NumberToTextConverter.toText(c.getNumericCellValue());
                                data.add(cellData);
                                //System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
                                //System.out.println(cellData);

                            }



                        }


                    }
                }

            }


        }
        return data;
    }


}
