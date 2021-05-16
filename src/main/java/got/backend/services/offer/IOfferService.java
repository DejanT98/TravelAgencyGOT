package got.backend.services.offer;

import got.backend.model.Offer;
import got.backend.services.IService;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IOfferService extends IService<Offer> {
    public List<Offer> findWithSpecification(Specification<Offer> specification);
}
