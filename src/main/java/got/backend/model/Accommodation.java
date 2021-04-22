package got.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer"})
public class Accommodation extends BaseEntity {

    private String name;
    private String description;
    private int stars;
    private boolean internet;
    private double distanceFromDest;
    @OneToMany(mappedBy = "accommodation")
    private List<Room> rooms;
    @ManyToOne
    @JoinColumn(name = "accommodation")
    private Destination destination;

    public Accommodation() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public double getDistanceFromDest() {
        return distanceFromDest;
    }

    public void setDistanceFromDest(double distanceFromDest) {
        this.distanceFromDest = distanceFromDest;
    }
}
