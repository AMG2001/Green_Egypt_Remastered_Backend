package tech.amg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tech.amg.service.LoginService;
import tech.amg.views.MainPage;

import java.util.Scanner;


@Configuration
@ComponentScan(basePackages = "tech.amg")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(App.class);
        MainPage mainPage = context.getBean(MainPage.class);
        mainPage.show();
    }

}
