import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.Method;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;

public class ApiTestingExercise1 extends BaseTestCase{

    @Test(priority = 0)
    public void getWeatherDetails(){

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request().get("/Hyderabad");

        String responseBody = response.getBody().asString();

        System.out.println("Response Body is: "+ responseBody);

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200, "Correct status code returned");
    }


    @Test(priority = 1)
    public void getWeatherDetailsInvalidCity(){

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request().get("/123123123");

        String responseBody = response.getBody().asString();

        System.out.println("Response Body is: " + responseBody);

        int statusCode = response.statusCode();

        Assert.assertEquals(statusCode, 200, "Correct status code returned");

    }

    @Test(priority = 2)
    public void getWeatherStatusLine(){

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request().get("/Hyderabad");

        String responseBody = response.getBody().asString();

        System.out.println("Response Body is: "+ responseBody);

        String statusLine = response.getStatusLine();

        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");
    }

    @Test(priority = 2)
    public void getWeatherDetailsInvalidCity1(){



    }

}