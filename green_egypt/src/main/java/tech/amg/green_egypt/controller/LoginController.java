package tech.amg.green_egypt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.amg.green_egypt.domain.dto.LoggedUserDto;
import tech.amg.green_egypt.domain.dto.LoginUserDto;
import tech.amg.green_egypt.domain.model.User;
import tech.amg.green_egypt.mappers.LoggedUserMapper;
import tech.amg.green_egypt.mappers.UserMapper;
import tech.amg.green_egypt.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoggedUserMapper loggedUserMapper;
    private LoginService loginService;
    private LoggedUserMapper userMapper;

    @Autowired
    public LoginController(LoginService loginService, LoggedUserMapper userMapper, LoggedUserMapper loggedUserMapper) {
        this.loginService = loginService;
        this.userMapper = userMapper;
        this.loggedUserMapper = loggedUserMapper;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginUserDto loginUserDto) {
        User user = loginService.login(loginUserDto);
        LoggedUserDto loggedUserDto = loggedUserMapper.map(user);
        return ResponseEntity.ok(loggedUserDto);
    }
    
}
