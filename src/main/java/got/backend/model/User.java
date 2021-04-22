package got.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Enabled;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "[user]")
@JsonIgnoreProperties({ "hibernateLazyInitializer"})
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    public User() {}


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
