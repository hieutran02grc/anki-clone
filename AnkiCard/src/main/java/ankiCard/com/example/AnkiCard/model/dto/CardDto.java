package ankiCard.com.example.AnkiCard.model.dto;

import lombok.Data;
import java.util.Date;

@Data
public class CardDto {
    private String hint;
    private String answer;
    private String audio;
    private String picture;
    private Long remainWaitingTime;
    private Date createTime;
    private Integer deskId;
}
