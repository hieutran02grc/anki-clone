package ankiCard.com.example.AnkiCard.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardValueDTO {

//    private  Integer id;
    private String value;
    private Integer cardTypeAttributeId;
    private Integer cardTypeId;
    private Integer cardId;


}
