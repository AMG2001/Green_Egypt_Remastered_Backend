package tech.amg.views;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.amg.domain.dto.LoggedUserDto;
import tech.amg.service.LoginService;

import java.util.Scanner;

@Service
public class LoginPage {


    private LoginService loginService;

    @Autowired
    public LoginPage(LoginService loginService) {
        this.loginService = loginService;
    }

    public void show() {
        Scanner get = new Scanner(System.in);
        System.out.print("Enter your email : ");
        String email = get.nextLine().trim();
        System.out.print("Enter your password : ");
        String password = get.nextLine().trim();
        LoggedUserDto loggedUserDto = loginService.login(email,password);
        System.out.println(loggedUserDto);
        System.out.println("Welcome back " + loggedUserDto.firstName());
    }
}
