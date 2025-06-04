package tech.amg.green_egypt.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.amg.green_egypt.domain.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    boolean existsByEmail(String email);
    Optional<User> getUserByEmail(String email);
}
