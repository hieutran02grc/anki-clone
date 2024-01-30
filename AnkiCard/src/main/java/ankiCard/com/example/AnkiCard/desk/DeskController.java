package ankiCard.com.example.AnkiCard.desk;

import ankiCard.com.example.AnkiCard.model.Card;
import ankiCard.com.example.AnkiCard.model.Desk;
import ankiCard.com.example.AnkiCard.model.dto.DeskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/desk")
public class DeskController {
    @Autowired
    DeskService deskService;

    @GetMapping()
    public ResponseEntity<List<DeskDto>> getDesk(){
        List<DeskDto> desks = deskService.getAllDesk();
        return new ResponseEntity<>(desks, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> addDesk(@RequestBody Map<String, String> requestMap){

        String doAddDesk = deskService.addNewDesk(requestMap);
        if (doAddDesk.equals("success")){
            return new ResponseEntity<>("succes",HttpStatus.OK);
        }
        return new ResponseEntity<>("failed",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCardsOnDesk(@PathVariable("id") Integer deskId) {
        List<Card> cards = deskService.getCardsByDeskId(deskId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }



}
