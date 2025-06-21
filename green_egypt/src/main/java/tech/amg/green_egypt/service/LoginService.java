package tech.amg.green_egypt.service;

import org.springframework.stereotype.Service;

import tech.amg.green_egypt.domain.dto.LoginUserDto;
import tech.amg.green_egypt.domain.model.User;
import tech.amg.green_egypt.exception.InvalidCredintialsException;
import tech.amg.green_egypt.exception.UserNotFoundException;
import tech.amg.green_egypt.repository.UserRepo;

@Service
public class LoginService {

    private UserRepo userRepo;
    private GEPasswordEncoder passwordEncoder;

    public LoginService(UserRepo userRepo, GEPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(LoginUserDto loginUserDto) {
        User user = userRepo.getUserByEmail(loginUserDto.email())
        .orElseThrow(UserNotFoundException::new);
        if (!passwordEncoder.matches(loginUserDto.password(), user.password())) {
            throw new InvalidCredintialsException();
        }
        return user;
    }
}
