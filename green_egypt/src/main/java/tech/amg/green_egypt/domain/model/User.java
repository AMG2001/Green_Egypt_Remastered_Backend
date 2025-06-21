package tech.amg.green_egypt.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import tech.amg.green_egypt.domain.enums.UserType;

@Document(collection = "users")
public record User(
        @Email @NotNull String email,
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull String password,
        @NotNull String mobileNumber,
        @NotNull @JsonProperty("userType") UserType userType,
        String createdAt,
        String updatedAt
) {}