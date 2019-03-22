import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EndToEndLibraryDataProvider {

    String book1= "aaaaa";
    String aisle1="124";
    String book2= "bbbbbb";
    String aisle2="125";
    String book3= "cccccc";
    String aisle3="125";

    @Test(dataProvider = "books")
    public void addBook(String isbn,String aisle){
        RestAssured.baseURI="http://216.10.245.166";
        Response response = given().header("Content-Type","application/json")
                .body(PayLoad.addBook(isbn,aisle))
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200).extract().response();
        String rawToString= response.asString();

        JsonPath jp = new JsonPath(rawToString);
        String getID= jp.get("ID");
        String getMsg=jp.get("Msg");
        System.out.println(getMsg +"  isbn = "+ getID);

    }

    //entering diffrent set of data by using @dataprovider

    @DataProvider(name="books")
    public Object[][] getData(){
        return new Object[][]{{book1,aisle1},{book2,aisle2},{book3,aisle3} };

    }




    @Test
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


    @Test(dataProvider = "books")
    public void deleteBook(String isbn,String aisle){
    RestAssured.baseURI="http://216.10.245.166";
    Response deleteResponse = given().body("{\r\n \r\n\"ID\" : \""+isbn+""+aisle+"\"\r\n \r\n}")
            .when().post("/Library/DeleteBook.php")
            .then().assertThat().statusCode(200).extract().response();
    String deleteString= deleteResponse.asString();
    JsonPath deleteRawToJson= new JsonPath(deleteString);
    String printDeleteResponse= deleteRawToJson.get("msg");
        System.out.println(printDeleteResponse);


    }
}
