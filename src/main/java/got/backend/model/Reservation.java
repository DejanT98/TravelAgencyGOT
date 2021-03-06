package got.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer"})
public class Reservation extends BaseEntity {

    private boolean reserved;
    @Temporal(TemporalType.DATE)
    private Date paymentDeadline;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "FK_user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "FK_offer_id", referencedColumnName = "id")
    private Offer offer;

    public Reservation() {}


    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
