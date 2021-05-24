package by.testbot.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offer_id;
    private String link;
    private String name;
    private boolean isTop;

    @ManyToMany
    @JoinTable(name = "offers_users",
            joinColumns = {
                    @JoinColumn(name = "offer_id", referencedColumnName = "offer_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "user_id",
                            nullable = false, updatable = false)})
    private Set<User> users;

}
