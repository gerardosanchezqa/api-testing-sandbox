import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting extends BaseTestCase{

    ApiResponse response;
    BaseActions weatherApiActions = new BaseActions(new RestAssuredHttpClient());

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

//    @Test
//    public void getWeatherStatusLine(){
//        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
//        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
//    }

    @Test
    public void getWeatherHeaders(){
        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
        Assert.assertEquals(response.header("Content-type"), "application/json");
        Assert.assertEquals(response.header("Server"), "nginx/1.14.0");
        Assert.assertEquals(response.header("Content-encoding"), "gzip");
    }

    @Test
    public void getWeatherMessageBody(){
        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
        String responseBody = response.bodyAsString();
        Assert.assertTrue(responseBody.contains("Hyderabad"));
    }

//    @Test
//    public void verifyCityInJsonResponse(){
//        response = weatherApiActions.getWeatherDetailsWithCity("Hyderabad");
//        String cityFromResponse = weatherApiActions.getCityFromJsonResponse(response);
//        Assert.assertEquals(cityFromResponse, "Hyderabad", "Correct city name received in the response");
//    }

//    @Test
//    public void RegistrationWithPost(){
//        String firstName = "Virender";
//        String lastName = "Singh";
//        String userName = "randomUsernamee";
//        String password = "password1";
//        String email = "randomeemail@gmail.com";
//
//        WeatherRequestBuilder postRequest = new WeatherRequestBuilder();
//        postRequest.setFirstName(firstName);
//        postRequest.setLastName(lastName);
//        postRequest.setUserName(userName+(int)(Math.random()*100));
//        postRequest.setPassword(password);
//        postRequest.setEmail((int)(Math.random()*100)+email);
//
//        response = postRequest.sendPostRequestAndReceiveResponse();
//        Assert.assertEquals(response.getStatusCode(), 201);
//
//        RegistrationSuccessResponse responseMessage = response.as(RegistrationSuccessResponse.class, ObjectMapperType.GSON);
//        Assert.assertEquals(responseMessage.getSuccessCode(), "OPERATION_SUCCESS", "Correct success code was returned");
//    }
}
