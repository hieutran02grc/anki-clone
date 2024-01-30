package ankiCard.com.example.AnkiCard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DailyLimit extends IdBasedEntity{
    @Column(name = "new_card_per_day")
    private Integer newCardPerDay;

    @Column(name = "max_review_per_day")
    private Integer maxReviewCardPerDay;

    @OneToOne()
    @JoinColumn(name = "desk_id",referencedColumnName = "id")
    private Desk desk;
}
