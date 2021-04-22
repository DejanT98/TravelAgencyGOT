package got.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Countries")
@JsonIgnoreProperties({ "hibernateLazyInitializer"})
public class Country extends BaseEntity implements Serializable{

    @Column(name = "name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Destination> destinations;

    public Country() {}

    public Country(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.destinations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
