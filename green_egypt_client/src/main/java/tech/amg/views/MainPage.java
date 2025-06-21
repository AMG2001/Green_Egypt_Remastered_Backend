package tech.amg.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MainPage {

    private LoginPage loginPage;
    private RegisterPage registerPage;

    public MainPage() {

    }

    boolean isRunning = true;

    @Autowired
    public MainPage(LoginPage loginPage, RegisterPage registerPage) {
        this.loginPage = loginPage;
        this.registerPage = registerPage;
    }

    public void show() {
       while (isRunning){
           System.out.println("Choose the number of the operation that you want to perform :");
           System.out.println("1 -> login");
           System.out.println("2 -> register");
           System.out.println("3 -> shutdown");
           System.out.print("Enter your choice: ");
           Scanner get = new Scanner(System.in);
           int choice = get.nextInt();
           switch (choice) {
               case 1:
                   loginPage.show();
                   break;
               case 2:
                   registerPage.show();
                   break;
               case 3:
                   isRunning = false;
           }
       }
    }
}
