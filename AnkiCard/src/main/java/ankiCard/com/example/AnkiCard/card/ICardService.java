package ankiCard.com.example.AnkiCard.card;

import ankiCard.com.example.AnkiCard.model.Card;
import ankiCard.com.example.AnkiCard.model.dto.CardDto;
import ankiCard.com.example.AnkiCard.model.dto.CardValueDTO;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public interface ICardService {
    String addToDeskByDeskId(Map<String, String> requestmap);
    ResponseEntity<?> addAllCardValue(List<CardValueDTO> CardValueDTO);
    ResponseEntity<?> updateChosenOption(Map<String, String> requestMap);
}
