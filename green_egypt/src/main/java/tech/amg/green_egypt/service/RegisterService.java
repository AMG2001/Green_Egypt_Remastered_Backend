package tech.amg.green_egypt.service;

import org.springframework.stereotype.Service;

import tech.amg.green_egypt.domain.dto.RegisterUserDTO;
import tech.amg.green_egypt.domain.model.User;
import tech.amg.green_egypt.exception.EmailAlreadyExistException;
import tech.amg.green_egypt.mappers.UserMapper;
import tech.amg.green_egypt.repository.UserRepo;

@Service
public class RegisterService {

    private UserRepo userRepo;
    private UserMapper mapper;
    private GEPasswordEncoder passwordEncoder;

    public RegisterService(UserRepo userRepo, UserMapper mapper, GEPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterUserDTO registeredUser) {
        checkIfEmailAlreadyExists(registeredUser.email());
        String encodedPassword = passwordEncoder.encode(registeredUser.password());
        RegisterUserDTO encodedRegisterUserDto = buildPasswordHashedRegisterUserDTO(registeredUser,encodedPassword);
        System.out.println(encodedRegisterUserDto);
        User user = mapper.map(encodedRegisterUserDto);
        System.out.println(user);
        userRepo.save(user);
    }

    private void checkIfEmailAlreadyExists(String email) {
        if (userRepo.existsByEmail(email)) {
            throw new EmailAlreadyExistException();
        }
    }

    private RegisterUserDTO buildPasswordHashedRegisterUserDTO(RegisterUserDTO registeredUser,String encodedPassword) {
        return new RegisterUserDTO(
                registeredUser.firstName(),
                registeredUser.lastName(),
                registeredUser.email(),
                encodedPassword,
                registeredUser.mobileNumber(),
                registeredUser.userType()
        );
    }
}
