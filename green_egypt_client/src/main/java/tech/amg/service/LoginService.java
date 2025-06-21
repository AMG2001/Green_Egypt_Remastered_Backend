package tech.amg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.amg.config.GreenEgyptRestClientConfig;
import tech.amg.domain.dto.LoggedUserDto;
import tech.amg.domain.dto.LoginUserDto;

import java.net.URI;

@Service
public class LoginService {

    private GreenEgyptRestClientConfig<LoginUserDto,LoggedUserDto> client;

    @Autowired
    public LoginService(GreenEgyptRestClientConfig<LoginUserDto,LoggedUserDto> client) {
        this.client = client;
    }

    public LoggedUserDto login(String email, String password) {
        LoginUserDto body = new LoginUserDto(email,password);

        RequestEntity<LoginUserDto> requestEntity = new RequestEntity<>(
                body,
                new HttpHeaders(),
                HttpMethod.POST,
                URI.create(getLoginRequestPath())
        );

        ResponseEntity<LoggedUserDto> responseEntity = client.exchangeRequest(requestEntity, LoggedUserDto.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()) return  responseEntity.getBody();
        else return null;
    }

    private String getLoginRequestPath(){
        return client.getBaseUrl() + "/login";
    }
}
