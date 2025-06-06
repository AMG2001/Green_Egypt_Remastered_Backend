package tech.amg.green_egypt.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginUserDto {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}
