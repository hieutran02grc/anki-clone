package ankiCard.com.example.AnkiCard.card;

import ankiCard.com.example.AnkiCard.model.dto.CardValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    public ICardService cardService;

    @PostMapping()
    public ResponseEntity<?> addCardOnDesk(@RequestBody Map<String, String> requestMap){
        String addToDesk = cardService.addToDeskByDeskId(requestMap);
        return new ResponseEntity<>(addToDesk,HttpStatus.OK);
    }

    @PostMapping("/sendValue")
    public ResponseEntity<?> addValueToCard(@RequestBody List<CardValueDTO> cardValueList){
//        String addToDesk = cardService.addToDeskByDeskId(requestMap);
        return cardService.addAllCardValue(cardValueList);
    }

    @PostMapping("/learning/option")
    public ResponseEntity<?> updateIntervalOption(@RequestBody  Map<String, String> requestMap){
        return cardService.updateChosenOption(requestMap);
    }


}
