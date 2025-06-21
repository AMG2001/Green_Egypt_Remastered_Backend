package tech.amg.green_egypt.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import tech.amg.green_egypt.domain.dto.LoggedUserDto;
import tech.amg.green_egypt.domain.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoggedUserMapper {
    /**
     *        @NotNull String firstName,
     *         @NotNull String lastName,
     *         @Email @NotNull String email,
     *         @NotNull String mobileNumber,
     *         @NotNull @JsonProperty("userType") UserType userType
     * @param user
     * @return
     */
    @Mapping(target = "userType", source = "userType")
    LoggedUserDto map(User user);
}
