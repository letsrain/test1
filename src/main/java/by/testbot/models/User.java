package by.testbot.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import by.testbot.bot.BotState;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
@JsonInclude(Include.NON_NULL)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    @JsonIgnore
    private Long user_id;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Offer> offers;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecialOffer> specialOfferList;

    @Column(name = "ViberId", nullable = false)
    @JsonProperty("id")
    private String viberId;

    @JsonProperty("name")
    @Column(name = "Name", nullable = false)
    private String name;

    @JsonProperty("avatar")
    @Column(name = "Avatar")
    private String avatar;

    @JsonProperty("country")
    @Column(name = "Country", nullable = false)
    private String country;

    @JsonProperty("language")
    @Column(name = "Language", nullable = false)
    private String language;

    @JsonProperty("primary_device_os")
    @Transient
    private String primaryDeviceOs;

    @JsonProperty("api_version")
    @Transient
    private Integer apiVersion;

    @JsonProperty("mcc")
    @Transient
    private Integer mcc;

    @JsonProperty("mnc")
    @Transient
    private Integer mnc;

    @JsonProperty("device_type")
    @Transient
    private String deviceType;

    @JsonIgnore
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "BotState", nullable = false)
    private BotState botState;

}
