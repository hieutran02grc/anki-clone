package ankiCard.com.example.AnkiCard.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeskDto {
    private Integer id;
    private String deskName;
//    private Integer userId;
    private Integer maxReview;
    private Integer newCardPerDay;

    public DeskDto(Integer id, String deskName) {
        this.id = id;
        this.deskName = deskName;
//        this.userId = userId;
    }
}
