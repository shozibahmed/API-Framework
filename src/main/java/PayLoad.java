public class PayLoad {



    public static String addBook(String isbn, String aisle){

       String payload = "{\r\n\r\n\"name\":\"Learn Appium Automation with Ja\",\r\n\"isbn\":\""+isbn+"\",\r\n\"aisle\":\""+aisle+"\",\r\n\"author\":\"John foe\"\r\n}\r\n \r\n";
       return payload;
    }
}
