import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class BaseActions {

    public Response getWeatherDetailsWithCity(String city) {
        return RestAssured.given().when().get("/"+city);
    }

    public String getResourceFromJsonResponse(Response response, String neededResource) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        return jsonPathEvaluator.get(neededResource);
    }

    public String getCityFromJsonResponse(Response response) {
        return getResourceFromJsonResponse(response, "City");
    }

    public String getResponseSuccessCode(Response response) {
        return response.jsonPath().get("SuccessCode");
    }
}