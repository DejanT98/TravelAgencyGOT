package got.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer"})
public class RoomType extends BaseEntity{

    private int capacity;
    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms;

    public RoomType() {}


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
