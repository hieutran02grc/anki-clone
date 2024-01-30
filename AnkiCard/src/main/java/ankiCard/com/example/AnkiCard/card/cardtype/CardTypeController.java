package ankiCard.com.example.AnkiCard.card.cardtype;

import ankiCard.com.example.AnkiCard.model.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cardtypes")
public class CardTypeController {

    @Autowired
    private CardTypeService cardTypeService;

    // Get all card types
    @GetMapping
    public ResponseEntity<List<CardType>> getAllCardTypes() {
        List<CardType> cardTypes = cardTypeService.getAllCardTypes();
        return new ResponseEntity<>(cardTypes, HttpStatus.OK);
    }

    // Get a specific card type by ID
    @GetMapping("/{id}")
    public ResponseEntity<CardType> getCardTypeById(@PathVariable Long id) {
        CardType cardType = cardTypeService.getCardTypeById(id);
        return new ResponseEntity<>(cardType, HttpStatus.OK);
    }

    // Create a new card type
    @PostMapping
    public ResponseEntity<CardType> createCardType(@RequestBody CardType cardType) {
        CardType createdCardType = cardTypeService.createCardType(cardType);
        return new ResponseEntity<>(createdCardType, HttpStatus.CREATED);
    }

    // Update an existing card type
    @PutMapping("/{id}")
    public ResponseEntity<CardType> updateCardType(@PathVariable Long id, @RequestBody CardType cardType) {
        CardType updatedCardType = cardTypeService.updateCardType(id, cardType);
        return new ResponseEntity<>(updatedCardType, HttpStatus.OK);
    }

    // Delete a card type by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardType(@PathVariable Long id) {
        cardTypeService.deleteCardType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
