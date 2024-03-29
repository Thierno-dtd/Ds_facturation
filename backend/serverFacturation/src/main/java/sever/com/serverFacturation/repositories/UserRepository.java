package sever.com.serverFacturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sever.com.serverFacturation.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
