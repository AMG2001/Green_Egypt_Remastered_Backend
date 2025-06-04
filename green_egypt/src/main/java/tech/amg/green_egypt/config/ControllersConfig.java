package tech.amg.green_egypt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ControllersConfig {

    @Value("${server.servlet.context-path}")
    private String baseUrl;

    public String getRegisterPageUrl(){
        return "/register";
    }

    public String getLoginPageUrl(){
        return "/login";
    }

    public String getBaseUrl(){
        return baseUrl;
    }
}
