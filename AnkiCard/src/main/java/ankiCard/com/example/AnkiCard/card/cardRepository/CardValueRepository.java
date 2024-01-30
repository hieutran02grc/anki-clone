package ankiCard.com.example.AnkiCard.card.cardRepository;

import ankiCard.com.example.AnkiCard.model.CardValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardValueRepository extends JpaRepository<CardValue, Integer> {
}
