package got.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Countries")
public class Country {

    @Id
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
