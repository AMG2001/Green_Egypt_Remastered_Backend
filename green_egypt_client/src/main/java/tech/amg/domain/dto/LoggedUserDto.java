package tech.amg.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoggedUserDto(@NotNull
                            String firstName,
                            String lastName,
                            @Email
                            @NotNull
                            String email,
                            @NotNull
                            @Size(min = 11, max = 11)
                            String mobileNumber,
                            @NotNull
                            String userType) {

}
