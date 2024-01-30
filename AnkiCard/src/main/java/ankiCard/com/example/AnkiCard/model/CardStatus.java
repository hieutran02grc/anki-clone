package ankiCard.com.example.AnkiCard.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Entity
//public class CardStatus extends IdBasedEntity{
//
//    @Column(name = "status")
//    private String status;
//
//    @Column(name = "description")
//    private String description;
//
//
//
//}

public enum CardStatus {
   NEW, LEARNING, RELEARN;
}


