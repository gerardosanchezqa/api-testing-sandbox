import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherRequestBuilder {

    private JSONObject postRequestParams = new JSONObject();
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

    public void setFirstName(String firstName) {
        try {
            postRequestParams.put("FirstName", firstName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setLastName(String lastName) {
        try {
            postRequestParams.put("LastName", lastName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setUserName(String userName) {
        try {
            postRequestParams.put("UserName", userName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setPassword(String password) {
        try {
            postRequestParams.put("Password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setEmail(String email) {
        try {
            postRequestParams.put("Email", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Response sendPostRequestAndReceiveResponse() {
        RestAssured.baseURI ="http://restapi.demoqa.com/customer";
        Response response = RestAssured.given().contentType("application/json").body(postRequestParams.toString()).when().post("/register");
        RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city/";
        return response;
    }
}