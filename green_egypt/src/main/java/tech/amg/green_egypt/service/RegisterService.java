package tech.amg.green_egypt.service;

import org.springframework.stereotype.Service;

import tech.amg.green_egypt.domain.dto.RegisterUserDTO;
import tech.amg.green_egypt.domain.model.User;
import tech.amg.green_egypt.exception.EmailAlreadyExistException;
import tech.amg.green_egypt.mappers.RegisterUserDtoToUserMapper;
import tech.amg.green_egypt.repository.UserRepo;

@Service
public class RegisterService {

    private UserRepo userRepo;
    private RegisterUserDtoToUserMapper mapper;
    private GEPasswordEncoder passwordEncoder;

    public RegisterService(UserRepo userRepo, RegisterUserDtoToUserMapper mapper, GEPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterUserDTO registeredUser) {
        checkIfEmailAlreadyExists(registeredUser.getEmail());
        String encodedPassword = passwordEncoder.encode(registeredUser.getPassword());
        registeredUser.setPassword(encodedPassword);
        User user = mapper.map(registeredUser);
        userRepo.save(user);
    }

    public void checkIfEmailAlreadyExists(String email) {
        if (userRepo.existsByEmail(email)) {
            throw new EmailAlreadyExistException();
        }
    }
}
