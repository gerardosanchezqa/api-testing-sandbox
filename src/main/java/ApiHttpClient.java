public interface ApiHttpClient {

    String API_URL = "http://restapi.demoqa.com/utilities/weather/city/";

    ApiResponse get(String url);

}