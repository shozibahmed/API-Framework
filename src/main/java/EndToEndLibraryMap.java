import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class EndToEndLibraryMap {

    @Test(priority = 0)
    public void addBook(){
        HashMap<String, Object> addbook=new HashMap<String, Object>();
        addbook.put("name","RestAssured");
        addbook.put("isbn","great");
        addbook.put("aisle","123");
        addbook.put("author","Yusuf");




        RestAssured.baseURI="http://216.10.245.166";
        Response response = given().header("Content-Type","application/json")
                .body(addbook)
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response();
        String rawToString= response.asString();

        JsonPath jp = new JsonPath(rawToString);
        String getID= jp.get("ID");
        String getMsg=jp.get("Msg");
        System.out.println(getMsg +"  isbn = "+ getID);

    }






    @Test(priority = 1)
    public void retriveBook(){
        RestAssured.baseURI="http://216.10.245.166";
        Response responseBookAuthour =
                given()
                        .when().get("/Library/GetBook.php?AuthorName=John foe")
                        .then().statusCode(200).extract().response();

       String rawToAuthour= responseBookAuthour.asString();
      JsonPath jpAuthor= new JsonPath(rawToAuthour);

        System.out.println(jpAuthor.get("aisle")+ "/n"+jpAuthor.get("book_name"));



    }


    @Test(priority = 2)
    public void deleteBook(){
    RestAssured.baseURI="http://216.10.245.166";
    Response deleteResponse = given().body("{\r\n \r\n\"ID\" : \"great123\"\r\n \r\n}")
            .when().post("/Library/DeleteBook.php")
            .then().assertThat().statusCode(200).extract().response();
    String deleteString= deleteResponse.asString();
    JsonPath deleteRawToJson= new JsonPath(deleteString);
    String printDeleteResponse= deleteRawToJson.get("msg");
        System.out.println(printDeleteResponse);


    }
}
