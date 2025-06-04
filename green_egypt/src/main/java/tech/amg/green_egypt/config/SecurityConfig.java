package tech.amg.green_egypt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class SecurityConfig {

    private List<String> authenticatedEndpoints = new ArrayList<>();
    private List<String> nonAuthenticatedEndpoints = new ArrayList<>();
    private final ControllersConfig controllersConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("Configuring security with non-auth endpoints");
        
        http
                .authorizeHttpRequests(requests ->
                        requests
                        // Note that request Matcher is working on the path after context path.        
                        .requestMatchers(convertStringListToStringArray(nonAuthenticatedEndpoints)).permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults()); // Enable CORS
        return http.build();
    }

    public SecurityConfig(ControllersConfig controllersConfig) {
        this.controllersConfig = controllersConfig;
        // define all authenticated and non authenticated endpoints.
        initiateRequestMatcherControllers();
    }

    private void initiateRequestMatcherControllers() {
        // define all non authenticated endpoints
        nonAuthenticatedEndpoints.add(controllersConfig.getRegisterPageUrl());
        nonAuthenticatedEndpoints.add(controllersConfig.getLoginPageUrl());

        // define all authenticated endpoints.
    }

    /**
     * Used in case the you want to convert List<String> to String[]
     *
     * @param list
     * @return
     */
    private String[] convertStringListToStringArray(List<String> list) {
        return list.toArray(new String[list.size()]);
    }
}
