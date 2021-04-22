package got.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer"})
public class Room extends BaseEntity{

    private int number;
    private String description;
    private boolean active;
    private boolean tv;
    private boolean ac;
    private boolean terrace;
    @OneToMany(mappedBy = "room")
    private List<Offer> offers;
    @ManyToOne
    @JoinColumn(name = "FK_room_type_id")
    private RoomType roomType;
    @ManyToOne
    @JoinColumn(name = "FK_accommodation_id")
    private Accommodation accommodation;

    public Room() { }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public boolean isTerrace() {
        return terrace;
    }

    public void setTerrace(boolean terrace) {
        this.terrace = terrace;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
