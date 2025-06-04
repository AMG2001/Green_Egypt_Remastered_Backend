package tech.amg.green_egypt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.amg.green_egypt.domain.dto.LoginUserDto;
import tech.amg.green_egypt.domain.model.User;
import tech.amg.green_egypt.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginUserDto loginUserDto) {
        User user = loginService.login(loginUserDto);
        user.setPassword("");
        return ResponseEntity.ok(user);
    }
    
}
