package ankiCard.com.example.AnkiCard.desk;

import ankiCard.com.example.AnkiCard.card.CardRepository;
import ankiCard.com.example.AnkiCard.desk.deskConfig.DailyLimitRepository;
import ankiCard.com.example.AnkiCard.model.Card;
import ankiCard.com.example.AnkiCard.model.DailyLimit;
import ankiCard.com.example.AnkiCard.model.Desk;
import ankiCard.com.example.AnkiCard.model.User;
import ankiCard.com.example.AnkiCard.model.dto.DeskDto;
import ankiCard.com.example.AnkiCard.security.AnkiUserDetail;
import ankiCard.com.example.AnkiCard.sm2.Sm2Constant;
import ankiCard.com.example.AnkiCard.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DeskService implements IDeskService{
    @Autowired
    private DeskRepository deskRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private DailyLimitRepository dailyLimitRepository;


    @Transactional
    @Override
    public List<DeskDto> getAllDesk() {
        List<Desk> desks = new ArrayList<>();

        try {

            User user = getUserFromAuth().getUser();
            desks = deskRepository.findByUser(user);

        }catch (Exception e){
            throw e;
        }
        List<DeskDto> deskDtos = new ArrayList<>();
        desks.forEach(desk -> {
            DeskDto deskDto = conVertToDeskDto(desk);
            DailyLimit dailyLimit = dailyLimitRepository.findByDeskId(desk.getId());
            deskDto.setMaxReview(dailyLimit.getMaxReviewCardPerDay());
            deskDto.setNewCardPerDay(dailyLimit.getNewCardPerDay());
            deskDtos.add(deskDto);
            }
        );
        return deskDtos;
    }
    private DeskDto conVertToDeskDto(Desk desk){
        DeskDto deskDto = new DeskDto(desk.getId(), desk.getNameDesk());
        return deskDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addNewDesk(Map<String, String> requestMap) {

        String name = requestMap.get("nameDesk");
        User user = getUserFromAuth().getUser();

        if(!deskRepository.existsByNameDeskAndUser_Id(name, user.getId())){

            //create desk
            try{
                Desk desk = new Desk();
                desk.setNameDesk(name);
                desk.setUser(user);
                Date date = new Date(System.currentTimeMillis());
                desk.setCreateTime(date);
                desk.setUpdateTime(date);
                deskRepository.save(desk);

                //create dailyLimit
                DailyLimit dailyLimit = new DailyLimit();
                dailyLimit.setDesk(desk);
                dailyLimit.setNewCardPerDay(Sm2Constant.newCardPerDay);
                dailyLimit.setMaxReviewCardPerDay(Sm2Constant.maxReviewCardPerDay);
                dailyLimitRepository.save(dailyLimit);
            }catch (Exception e){
                throw e;
            }
            return "success";
        }
       return "failed";
    }
    @Override
    public List<Card> getCardsByDeskId(Integer deskId) {
        return cardRepository.findByDesk_Id(deskId);
    }
    private AnkiUserDetail getUserFromAuth(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AnkiUserDetail) authentication.getPrincipal();

    }

}
