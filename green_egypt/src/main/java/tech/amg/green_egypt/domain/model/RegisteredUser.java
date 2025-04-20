package tech.amg.green_egypt.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;
import tech.amg.green_egypt.domain.enums.UserType;

@Data
public class RegisteredUser{
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String mobileNumber;
    @NotNull
    @JsonProperty("userType")  // Make sure Jackson knows the property name
    private UserType userType;

    public RegisteredUser() {
    }
}