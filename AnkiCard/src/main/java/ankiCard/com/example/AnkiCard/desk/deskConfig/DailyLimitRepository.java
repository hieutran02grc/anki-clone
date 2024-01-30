package ankiCard.com.example.AnkiCard.desk.deskConfig;

import ankiCard.com.example.AnkiCard.model.DailyLimit;
import ankiCard.com.example.AnkiCard.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyLimitRepository extends JpaRepository<DailyLimit, Integer> {

    @Query(value = "SELECT * FROM daily_limit WHERE desk_id = :deskId", nativeQuery = true)
    DailyLimit findByDeskId(Integer deskId);

}
