package tech.amg.green_egypt.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import tech.amg.green_egypt.domain.dto.RegisterUserDTO;
import tech.amg.green_egypt.domain.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    default User map(RegisterUserDTO userDTO) {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return new User(
                userDTO.email(),
                userDTO.firstName(),
                userDTO.lastName(),
                userDTO.password(),
                userDTO.mobileNumber(),
                userDTO.userType(),
                formattedDateTime,
                formattedDateTime
        );
    }
}
