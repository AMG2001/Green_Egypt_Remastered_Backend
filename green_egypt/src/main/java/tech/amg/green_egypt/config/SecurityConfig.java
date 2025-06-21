package tech.amg.green_egypt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@Slf4j
public class SecurityConfig {

    private List<String> nonAuthenticatedEndpoints = new ArrayList<>();
    private final ControllersConfig controllersConfig;
    // 3021 - etisalat
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers(convertStringListToStringArray(nonAuthenticatedEndpoints))
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection
                .cors(cors -> cors.configurationSource(
                        request -> buildCorsConfiguration()
                        )
                );
        return http.build();
    }

    public SecurityConfig(ControllersConfig controllersConfig) {
        this.controllersConfig = controllersConfig;
        initiateRequestMatcherControllers();
    }

    private void initiateRequestMatcherControllers() {
        // define all non authenticated endpoints with the correct context path
        String baseUrl = controllersConfig.getBaseUrl();
        nonAuthenticatedEndpoints.add(controllersConfig.getRegisterPageUrl());
        nonAuthenticatedEndpoints.add(controllersConfig.getLoginPageUrl());
    }

    /*
     * Used in case the you want to convert List<String> to String[]
     */
    private String[] convertStringListToStringArray(List<String> list) {
        return list.toArray(new String[list.size()]);
    }

    private CorsConfiguration buildCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
        corsConfiguration.setAllowCredentials(false);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }

}
