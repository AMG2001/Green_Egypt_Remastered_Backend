package tech.amg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import tech.amg.config.GreenEgyptRestClientConfig;
import tech.amg.domain.dto.RegisterUserDto;

import java.net.URI;

@Service
public class RegisterService {

    private GreenEgyptRestClientConfig<RegisterUserDto, Void> client;

    @Autowired
    public RegisterService(GreenEgyptRestClientConfig<RegisterUserDto, Void> client) {
        this.client = client;
    }

    public ResponseEntity<Void> register(RegisterUserDto body) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RequestEntity<RegisterUserDto> requestEntity = new RequestEntity<>(
                body,
                httpHeaders,
                HttpMethod.POST,
                URI.create(buildRegisterRequestPath())
        );
        return client.exchangeRequest(requestEntity, Void.class);
    }

    private String buildRegisterRequestPath() {
        return client.getBaseUrl() + "/register";
    }

}
