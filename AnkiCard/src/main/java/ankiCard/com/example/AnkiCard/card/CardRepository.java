package ankiCard.com.example.AnkiCard.card;

import ankiCard.com.example.AnkiCard.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findByDesk_Id(Integer deskId);

    Boolean existsByDesk_Id(Integer deskId);
}
