package got.backend.helpers;

import got.backend.model.Offer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class OfferSpecifications {

    public static Specification<Offer> isOfferAfter(Date date) {
        return new Specification<Offer>() {
            @Override
            public Predicate toPredicate(Root<Offer> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(root.get(Offer_.startDate), date);
            }
        };
    }

    public static Specification<Offer> isOfferBefore(Date date) {
        return new Specification<Offer>() {
            @Override
            public Predicate toPredicate(Root<Offer> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThan(root.get(Offer_.endDate), date);
            }
        };
    }
}
