package tech.amg.green_egypt.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import tech.amg.green_egypt.domain.enums.UserType;

public record RegisterUserDTO(@NotNull
                              String firstName,
                              @NotNull
                              String lastName,
                              @Email
                              @NotNull
                              String email,
                              @NotNull
                              String password,
                              @NotNull
                              String mobileNumber,
                              @NotNull
                              @JsonProperty("userType")  // Make sure Jackson knows the property name
                              UserType userType
) {

}