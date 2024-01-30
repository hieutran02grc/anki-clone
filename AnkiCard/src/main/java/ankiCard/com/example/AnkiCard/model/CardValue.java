package ankiCard.com.example.AnkiCard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card_value")
public class CardValue extends IdBasedEntity{

    private String value;


    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private CardTypeAttribute cardTypeAttribute;

    @ManyToOne
    @JoinColumn(name = "card_type_id")
    private CardType cardType;

    @ManyToOne()
    @JoinColumn(name = "card_id")
    private Card card;

}
