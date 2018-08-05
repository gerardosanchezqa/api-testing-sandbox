import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

public class BaseActions {

    private final ApiHttpClient apiHttpClient;

    public BaseActions(ApiHttpClient apiHttpClient) {
        this.apiHttpClient = apiHttpClient;
    }

    ApiResponse getWeatherDetailsWithCity(String city) {
        String url = "/" + city;
        return apiHttpClient.get(url);
    }

    String getResourceFromJsonResponse(Response response, String neededResource) {
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