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
public class Desk extends IdBasedEntity{

    @Column(name = "desk_name")
    private String nameDesk;

//    @Column(name = "user_id")
//    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "desk")
    @JsonIgnore()
    private Set<Card> cards;

}
