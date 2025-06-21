package tech.amg.green_egypt.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import tech.amg.green_egypt.domain.enums.UserType;

/**
 * This class represent the data that retrieved from BE after the login process done successfully
 */
public record LoggedUserDto(
        @NotNull String firstName,
        @NotNull String lastName,
        @Email @NotNull String email,
        @NotNull String mobileNumber,
        @NotNull @JsonProperty("userType") UserType userType
) {
}