package got.backend.helpers;

import got.backend.model.Offer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OfferSpecification implements Specification<Offer> {
    private final Offer offer;

    public OfferSpecification(Offer offer) {
        this.offer = offer;
    }

    @Override
    public Predicate toPredicate(Root<Offer> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        if(this.offer == null) {
            return null;
        }
        final List<Predicate> predicates = new ArrayList<>();

        if(this.offer.getStartDate() != null) {
            predicates.add(criteriaBuilder.greaterThan(root.get("startDate"), this.offer.getStartDate()));
        }
        if(this.offer.getEndDate() != null) {
            predicates.add(criteriaBuilder.lessThan(root.get("endDate"), this.offer.getEndDate()));

        }

        if(predicates.size() == 0) {
            return null;
        }
        return criteriaBuilder
                .and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
