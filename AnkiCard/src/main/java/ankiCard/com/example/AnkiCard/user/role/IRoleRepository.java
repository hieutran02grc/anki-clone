package ankiCard.com.example.AnkiCard.user.role;

import ankiCard.com.example.AnkiCard.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r WHERE r.name = :name")
    Role findbyName(String name);
}
