package got.backend.helpers;

import got.backend.model.Offer;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Offer.class)
public class Offer_ {
    public static volatile SingularAttribute<Offer, Date> startDate;
    public static volatile SingularAttribute<Offer, Date> endDate;

}
