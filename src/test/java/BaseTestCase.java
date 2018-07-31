import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTestCase {

    //BaseActions weatherApiActions;

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
    }

}
