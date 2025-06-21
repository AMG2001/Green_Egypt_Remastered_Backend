package tech.amg.config;

import org.springframework.context.annotation.Scope;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Scope(scopeName = "prototype")
public class GreenEgyptRestClientConfig<RequestType,ResponseType> {
    private String baseUrl = "http://localhost:8080/green_egypt/api/v1";
    private String predefinedEmail = "mohamadamgad@gmail.com";
    private String predefinedPassword = "AMG2001";

    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<ResponseType> exchangeRequest(RequestEntity<RequestType> requestEntity , Class<ResponseType> responseClass){
        return restTemplate.exchange(requestEntity,responseClass);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPredefinedEmail() {
        return predefinedEmail;
    }

    public String getPredefinedPassword() {
        return predefinedPassword;
    }
}
