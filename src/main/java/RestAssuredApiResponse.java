import com.jayway.restassured.response.Response;

public class RestAssuredApiResponse implements ApiResponse {

    private Response response;

    public RestAssuredApiResponse(Response response) {
        this.response = response;
    }

    @Override
    public int getStatusCode() {
        return response.getStatusCode();
    }

    @Override
    public String header(String name) {
        return response.header(name);
    }

    @Override
    public String bodyAsString() {
        return response.getBody().asString();
    }
}
