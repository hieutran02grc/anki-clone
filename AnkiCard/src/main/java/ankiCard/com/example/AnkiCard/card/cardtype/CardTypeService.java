package ankiCard.com.example.AnkiCard.card.cardtype;


import ankiCard.com.example.AnkiCard.card.cardRepository.CardTypeRepository;
import ankiCard.com.example.AnkiCard.model.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardTypeService {

    @Autowired
    private CardTypeRepository cardTypeRepository;

    public List<CardType> getAllCardTypes() {
        return cardTypeRepository.findAll();
    }

    public CardType getCardTypeById(Long id) {
        Optional<CardType> optionalCardType = cardTypeRepository.findById(id);
        return optionalCardType.orElse(null);
    }

    public CardType createCardType(CardType cardType) {
        // Perform any business logic validation if needed
        return cardTypeRepository.save(cardType);
    }

    public CardType updateCardType(Long id, CardType cardType) {
        Optional<CardType> optionalExistingCardType = cardTypeRepository.findById(id);

        if (optionalExistingCardType.isPresent()) {
            CardType existingCardType = optionalExistingCardType.get();

            // Update fields based on your requirements
            existingCardType.setName(cardType.getName());
            existingCardType.setCardTypeAttributes(cardType.getCardTypeAttributes());

            // Save the updated entity
            return cardTypeRepository.save(existingCardType);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteCardType(Long id) {
        cardTypeRepository.deleteById(id);
    }
}
