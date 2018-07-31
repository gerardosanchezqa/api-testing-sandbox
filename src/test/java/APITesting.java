import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting extends BaseTestCase{

    Response response;
    BaseActions weatherApiActions = new BaseActions();

    @Test
    public void getWeatherDetails(){
        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getWeatherDetailsInvalidCity(){
        response = weatherApiActions.getWeatherDetailsWithCity("Abcdefg");
        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    public void getWeatherStatusLine(){
        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void getWeatherHeaders(){
        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
        Assert.assertEquals(response.header("Content-type"), "application/json");
        Assert.assertEquals(response.header("Server"), "nginx/1.12.2");
        Assert.assertEquals(response.header("Content-encoding"), "gzip");
    }

    @Test
    public void getWeatherMessageBody(){
        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Hyderabad"));
    }

    @Test
    public void verifyCityInJsonResponse(){
        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
        String cityFromResponse = weatherApiActions.getCityFromJsonResponse(response);
        Assert.assertEquals(cityFromResponse, "Hyderabad", "Correct city name received in the response");
    }

    @Test
    public void RegistrationWithPost(){
        String firstName = "Virender";
        String lastName = "Singh";
        String userName = "sdimpleuser2dd2011";
        String password = "password1";
        String email = "sample2ee26d9@gmail.com";

        WeatherRequestBuilder postRequest = new WeatherRequestBuilder();
        postRequest.setFirstName(firstName);
        postRequest.setLastName(lastName);
        postRequest.setUserName(userName);
        postRequest.setPassword(password);
        postRequest.setEmail(email);

        response = postRequest.sendPostRequestAndReceiveResponse();

        System.out.println(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 201);

        String responseSuccessCode = weatherApiActions.getResponseSuccessCode(response);
        Assert.assertEquals("Correct success code was returned", responseSuccessCode, "OPERATION, SUCCESS");
    }

}
