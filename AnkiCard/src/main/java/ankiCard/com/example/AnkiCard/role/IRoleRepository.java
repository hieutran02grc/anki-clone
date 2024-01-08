package ankiCard.com.example.AnkiCard.role;

import ankiCard.com.example.AnkiCard.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String name);
}
