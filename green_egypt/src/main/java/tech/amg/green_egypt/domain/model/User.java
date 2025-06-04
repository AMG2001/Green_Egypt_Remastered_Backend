package tech.amg.green_egypt.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;
import tech.amg.green_egypt.domain.enums.UserType;

@Data
@Document(collection = "users")
public class User {
    
    @Email
    @NotNull
    private String email;
    
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String password;
    @NotNull
    private String mobileNumber;
    @NotNull
    @JsonProperty("userType")
    private UserType userType;

    private String createdAt;
    private String updatedAt;

    public User() {
    }

}