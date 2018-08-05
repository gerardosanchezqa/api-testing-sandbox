import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class RestAssuredHttpClient implements ApiHttpClient {

    public RestAssuredHttpClient() {
        RestAssured.baseURI = ApiHttpClient.API_URL;
    }

    @Override
    public ApiResponse get(String url) {
        Response response = RestAssured.given().when().get(url);
        return new RestAssuredApiResponse(response);
    }
}