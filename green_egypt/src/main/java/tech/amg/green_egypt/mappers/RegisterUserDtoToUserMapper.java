package tech.amg.green_egypt.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import tech.amg.green_egypt.domain.dto.RegisterUserDTO;
import tech.amg.green_egypt.domain.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegisterUserDtoToUserMapper {

    User map(RegisterUserDTO userDTO);

    @AfterMapping
    default void mapUserDtoToUser(RegisterUserDTO userDTO, @MappingTarget User user) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        user.setCreatedAt(formattedDateTime);
        user.setUpdatedAt(formattedDateTime);
    }
}
