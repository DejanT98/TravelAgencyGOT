package got.backend.helpers;

import got.backend.model.Offer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        Specification<Offer> specification = null;

        if(this.offer.getStartDate() != null) {
            specification = OfferSpecifications.isOfferAfter(offer.getStartDate());
        }
        if(this.offer.getEndDate() != null) {
            specification = specification == null ?
                    OfferSpecifications.isOfferBefore(offer.getEndDate()) :
                    specification.and(OfferSpecifications.isOfferBefore(offer.getEndDate()));
        }
        System.out.println(specification);

        if(specification == null) {
            return null;
        }
        return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
    }
}
