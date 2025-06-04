package tech.amg.green_egypt.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class GEPasswordEncoder {
    
    private final PasswordEncoder passwordEncoder;

    public GEPasswordEncoder() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Encode a raw password using BCrypt
     * @param rawPassword the raw password to encode
     * @return the encoded password
     */
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Verify if a raw password matches an encoded password
     * @param rawPassword the raw password to verify
     * @param encodedPassword the encoded password to check against
     * @return true if the passwords match, false otherwise
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
} 