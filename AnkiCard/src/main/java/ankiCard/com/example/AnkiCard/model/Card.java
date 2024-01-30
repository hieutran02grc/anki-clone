package ankiCard.com.example.AnkiCard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Card extends IdBasedEntity{

    @Column(name = "intervalTime")
    private Integer interval;

    @Column(name = "dueTo")
    private Date dueTo;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "ease")
    private Float ease;

//    @ManyToOne
//    @JoinColumn(name = "card_status", referencedColumnName = "id")
    private CardStatus cardStatus;

    @ManyToOne
    @JoinColumn(name = "desk_id",referencedColumnName = "id")
    @JsonIgnore
    private Desk desk;

    @ManyToOne
    @JoinColumn(name = "typecard_id", referencedColumnName = "id")
    private CardType cardType;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CardValue> cardValues;


}
