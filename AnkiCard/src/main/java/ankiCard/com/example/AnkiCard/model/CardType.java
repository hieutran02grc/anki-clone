package ankiCard.com.example.AnkiCard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card_type")
public class CardType extends IdBasedEntity {

    @Column(name = "name_card")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cardType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CardTypeAttribute> cardTypeAttributes;
}
