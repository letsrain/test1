package by.testbot.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="soffer")
public class SpecialOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sId;

    private String link;
    private String parentLink;
    private boolean alreadyTaken;
    private boolean clicked;

    @ManyToOne
    private User owner;

}
