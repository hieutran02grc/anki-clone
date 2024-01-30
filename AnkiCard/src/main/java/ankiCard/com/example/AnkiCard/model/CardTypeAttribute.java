package ankiCard.com.example.AnkiCard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "type_attribute")
public class CardTypeAttribute extends IdBasedEntity {

    @Column(name = "key_name", nullable = false, length = 64)
    private String keyName;

//    @Column(name = "value" ,nullable = false, length = 64)
//    private String value;

    @ManyToOne
    @JoinColumn(name = "card_type_id")
    private CardType cardType;

//    @ManyToOne
//    @JoinColumn(name = "card_id")
//    private Card card;
}
