package tech.amg.green_egypt.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record LoginUserDto(@NotNull
                           @Email
                           String email,
                           @NotNull
                           String password) {

}
