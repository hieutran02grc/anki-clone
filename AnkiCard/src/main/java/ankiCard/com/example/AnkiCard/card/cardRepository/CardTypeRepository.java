package ankiCard.com.example.AnkiCard.card.cardRepository;

import ankiCard.com.example.AnkiCard.model.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Long> {
    // You can add custom query methods if needed

    Optional<CardType> findById(Integer id);
}