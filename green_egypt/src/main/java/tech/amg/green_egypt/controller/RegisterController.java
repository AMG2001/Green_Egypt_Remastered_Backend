package tech.amg.green_egypt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import tech.amg.green_egypt.domain.model.RegisteredUser;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RegisteredUser register(@ModelAttribute RegisteredUser registeredUser) {
        System.out.println("registered User : " + registeredUser.toString());
        return registeredUser;
    }
}
