package ankiCard.com.example.AnkiCard.card;

import ankiCard.com.example.AnkiCard.card.cardRepository.CardTypeAttributeRepository;
import ankiCard.com.example.AnkiCard.card.cardRepository.CardTypeRepository;
import ankiCard.com.example.AnkiCard.card.cardRepository.CardValueRepository;
import ankiCard.com.example.AnkiCard.desk.DeskRepository;
import ankiCard.com.example.AnkiCard.model.*;
import ankiCard.com.example.AnkiCard.model.dto.CardValueDTO;
import ankiCard.com.example.AnkiCard.sm2.Sm2Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

import static ankiCard.com.example.AnkiCard.sm2.Sm2Constant.*;

@Service
public class CardService implements ICardService{
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private DeskRepository deskRepository;
    @Autowired
    private CardTypeRepository cardTypeRepository;
    @Autowired
    private CardTypeAttributeRepository cardTypeAttributeRepository;
    @Autowired
    private CardValueRepository cardValueRepository;

    public String addToDeskByDeskId(Map<String, String> requestmap){
        Integer deskId = Integer.valueOf(requestmap.get("deskId"));
        Integer cardTypeId = Integer.valueOf(requestmap.get("cardTypeId"));

        Optional<Desk> desk = deskRepository.findById(deskId);
        Optional<CardType> cardType = cardTypeRepository.findById(cardTypeId);

        System.out.println(desk.get());
        System.out.println(cardType.get());

        //create new card
        if (!desk.isEmpty()  || !cardType.isEmpty()){
            Card card = new Card();
            card.setInterval(defaulInterval);
            Date date = new Date(System.currentTimeMillis());
            card.setDueTo(date);
            card.setCreateTime(date);
            card.setUpdateTime(date);
            card.setEase(Sm2Constant.startingEase);
            card.setDesk(desk.get());
            card.setCardStatus(CardStatus.NEW);
            CardType cardType1 = cardType.get();
            card.setCardType(cardType1);

            cardRepository.save(card);
            return "success";
        }
        return "fail";
    }

    @Override
    public ResponseEntity<?> addAllCardValue(List<CardValueDTO> cardValueDTOList) {

//        CardValue cardValue = new CardValue();
        Optional<Card> card = cardRepository.findById(cardValueDTOList.get(0).getCardId());
        Optional<CardType> cardType = cardTypeRepository.findById(cardValueDTOList.get(0).getCardTypeId());

        try {
            cardValueDTOList.forEach(cardValueDTO -> {
                CardValue cardValue = new CardValue();
                cardValue.setValue(cardValueDTO.getValue());
                cardValue.setCard(card.get());
                cardValue.setCardType(cardType.get());
                cardValue.setCardTypeAttribute(cardTypeAttributeRepository.findById(cardValueDTO.getCardTypeAttributeId()).get());

                cardValueRepository.save(cardValue);
            });
            return new ResponseEntity<>("done", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("not done", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> updateChosenOption(Map<String, String> requestMap) {

        Card card = cardRepository.findById(Integer.valueOf((requestMap.get("cardId")))).get();
        String option = requestMap.get("option");

        try {
            if (option.equals("again")) {
                setNewInterval(card, 0);
            } else if (option.equals("hard")) {
                setNewInterval(card, 1);
            } else if (option.equals("good")) {
                setNewInterval(card, 2);
            } else if (option.equals("easy")) {
                setNewInterval(card, 3);
            } else {
                throw new RuntimeException("invalid value");
            }
        }catch (Exception e){
            throw e;
        }

        cardRepository.save(card);
        return new ResponseEntity<>("successful",HttpStatus.OK);
    }

    public void setNewInterval(Card card, Integer option) {
        Integer currentInterval = card.getInterval();
        Float ease = card.getEase();
        Integer newInterval = currentInterval;
        Date currentDate = card.getDueTo();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);


        switch (option){
            case 0:
                newInterval = (int)(currentInterval * 0.5);
                if (newInterval >= minimumInterval){
                    newInterval = minimumInterval;
                }
                calendar.add(Calendar.MINUTE, 5);
                currentDate = calendar.getTime();
                ease = ease - 0.2F;
                break;
            case 1:
                newInterval = (int) (currentInterval * hardInterval);
                calendar.add(Calendar.DATE, newInterval);
                currentDate = calendar.getTime();
                ease = ease - 0.15F;
                break;
            case 2:
                newInterval = (int)(currentInterval*ease*defaulInterval);
                calendar.add(Calendar.DATE, newInterval);
                currentDate = calendar.getTime();
                break;
            case 3:
                newInterval = (int)(currentInterval*ease*defaulInterval*easyBonous);
                calendar.add(Calendar.DATE, newInterval);
                currentDate = calendar.getTime();
                ease += 0.15F;
                break;
        }
        card.setEase(ease);
        card.setInterval(newInterval);
        card.setDueTo(currentDate);
    }
}
