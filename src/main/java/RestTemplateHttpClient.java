import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateHttpClient implements ApiHttpClient {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public ApiResponse get(String url) {
        final ResponseEntity<String> forEntity = restTemplate.getForEntity(API_URL + url, String.class);

        return new ApiResponse() {
            @Override
            public int getStatusCode() {
                return forEntity.getStatusCode().value();
            }

            @Override
            public String header(String name) {
                return forEntity.getHeaders().toSingleValueMap().get(name);
            }

            @Override
            public String bodyAsString() {
                return forEntity.getBody();
            }
        };
    }
}
