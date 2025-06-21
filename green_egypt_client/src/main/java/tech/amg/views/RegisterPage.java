package tech.amg.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.amg.domain.dto.RegisterUserDto;
import tech.amg.service.RegisterService;

import java.util.Scanner;

@Service
public class RegisterPage {

    private RegisterService client;

    @Autowired
    public RegisterPage(RegisterService registerService) {
        this.client = registerService;
    }

    public void show() {
        Scanner get = new Scanner(System.in);
        System.out.println("enter your first name : ");
        String firstName = get.nextLine();
        System.out.println("enter your last name : ");
        String lastName = get.nextLine();
        System.out.println("enter phone number : ");
        String mobileNumber = get.nextLine();
        System.out.println("enter your email : ");
        String email = get.nextLine();
        System.out.println("enter your password : ");
        String password = get.nextLine();
        System.out.println("enter your confirm password : ");
        String confirmPassword = get.nextLine();
        while (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match !!");
            System.out.println("enter your password : ");
            password = get.nextLine();
            System.out.println("enter your confirm password : ");
            confirmPassword = get.nextLine();
        }
        RegisterUserDto registeredUserDto = new RegisterUserDto(firstName, lastName, mobileNumber, email, password);
        System.out.println(registeredUserDto);
        ResponseEntity<Void> responseEntity = client.register(registeredUserDto);
        if(responseEntity.getStatusCode().is2xxSuccessful()) System.out.println("Registration done successfully");
        else if(responseEntity.getStatusCode().is4xxClientError()) System.out.println("Error while registration , check credentials");
        else System.out.println("Internal Server Error");
    }


}
