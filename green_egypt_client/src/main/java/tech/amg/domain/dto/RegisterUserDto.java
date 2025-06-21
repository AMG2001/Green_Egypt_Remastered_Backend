package tech.amg.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterUserDto(@NotNull
                              @NotEmpty
                              String firstName,
                              @NotNull
                              @NotEmpty
                              String lastName,
                              @Email
                              @NotNull
                              String email,
                              @NotNull
                              @NotEmpty
                              String password,
                              @Size(min = 11, max = 11)
                              String mobileNumber,
                              String userType) {


    /**
     * This constructor is used to fill the data before register process performed.
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param mobileNumber
     */
    public RegisterUserDto(
            @NotNull
            @NotEmpty
            String firstName,
            @NotNull
            @NotEmpty
            String lastName,
            @Size(min = 11, max = 11)
            String mobileNumber,
            @Email
            @NotNull
            String email,
            @NotNull
            @NotEmpty
            String password

    ) {
        this(firstName, lastName, email, password, mobileNumber, "USER");
    }

    /**
     * This record constructor is used after the register process is done.
     * as we need to shallow the password with empty value.
     * @param firstName
     * @param lastName
     * @param email
     * @param mobileNumber
     */
    public RegisterUserDto(
            @NotNull
            @NotEmpty
            String firstName,
            @NotNull
            @NotEmpty
            String lastName,
            @Email
            @NotNull
            String email,
            @Size(min = 11, max = 11)
            String mobileNumber
    ) {
        this(firstName, lastName, email, "", mobileNumber, "USER");
    }
}

