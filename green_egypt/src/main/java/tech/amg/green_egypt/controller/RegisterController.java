package tech.amg.green_egypt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.amg.green_egypt.domain.model.RegisteredUser;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public RegisteredUser register(@RequestBody RegisteredUser registeredUser) {
        System.out.println("registered User : " + registeredUser.toString());
        return registeredUser;
    }
}
