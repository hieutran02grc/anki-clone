package ankiCard.com.example.AnkiCard.user;

import ankiCard.com.example.AnkiCard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
