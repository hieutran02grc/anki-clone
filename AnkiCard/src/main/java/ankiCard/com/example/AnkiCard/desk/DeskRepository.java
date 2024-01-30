package ankiCard.com.example.AnkiCard.desk;

import ankiCard.com.example.AnkiCard.model.Desk;
import ankiCard.com.example.AnkiCard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DeskRepository extends JpaRepository<Desk, Integer> {
    Boolean existsByNameDesk(String name);

    Boolean existsByNameDeskAndUser_Id(String name, Integer userId);

    List<Desk> findByUser(User user);

}
