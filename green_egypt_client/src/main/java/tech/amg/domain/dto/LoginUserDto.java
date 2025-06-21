package tech.amg.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginUserDto(@NotNull @Email String email, @NotNull @Size(min = 6) String password) {

}
