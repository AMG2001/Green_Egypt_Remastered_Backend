package tech.amg.green_egypt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.amg.green_egypt.domain.dto.RegisterUserDTO;
import tech.amg.green_egypt.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;
    
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody RegisterUserDTO registeredUser) {
            registerService.registerUser(registeredUser);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
}
