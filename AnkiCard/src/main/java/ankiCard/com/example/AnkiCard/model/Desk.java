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
public class Desk extends IdBasedEntity{

    @Column(name = "desk_name")
    private String nameDesk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @OneToMany(mappedBy = "desk" , fetch = FetchType.LAZY)
    @JsonIgnore()
    private Set<Card> cards;

    @OneToOne(mappedBy = "desk")
    private DailyLimit dailyLimit;

}
