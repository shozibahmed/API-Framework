import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestSample {
 private static ExcelToMap a=new ExcelToMap();

@Test
    public void getData() throws Exception{
   for(Map<String,String> m: ExcelToMap.readAllData()){


       System.out.println(m.get("Aisle"));
   }



}



}








