package ankiCard.com.example.AnkiCard.user;

import ankiCard.com.example.AnkiCard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
