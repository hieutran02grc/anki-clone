package ankiCard.com.example.AnkiCard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Card extends IdBasedEntity{

    private String hint;
    private String answer;
    private String audio;
    private String picture;

    @Column(name = "remain_waiting_time")
    private Integer remainWaitingTime;

    @Column(name = "create_time")
    private Date createTime;

    @ManyToOne
    @JoinColumn(name = "desk_id",referencedColumnName = "id")
    private Desk desk;
}
