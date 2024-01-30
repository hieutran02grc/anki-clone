package ankiCard.com.example.AnkiCard.desk;

import ankiCard.com.example.AnkiCard.model.Card;
import ankiCard.com.example.AnkiCard.model.Desk;
import ankiCard.com.example.AnkiCard.model.dto.DeskDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IDeskService {
    List<DeskDto> getAllDesk();
    String addNewDesk(Map<String, String> name);
    List<Card> getCardsByDeskId(Integer desId);
}
