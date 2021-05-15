package got.backend.repository;

import got.backend.model.Offer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OfferRepository extends IGenericRepository<Offer>, JpaSpecificationExecutor<Offer> {
//    findAllWithSpec(String spec);
}
