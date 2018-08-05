public interface ApiResponse {

    int getStatusCode();

    String header(String name);

    String bodyAsString();
}
