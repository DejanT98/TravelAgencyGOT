package got.backend.services.accommodation;

import got.backend.model.Accommodation;
import got.backend.model.Offer;
import got.backend.services.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IAccommodationService extends IService<Accommodation> {
    Page<Accommodation> findAll(Pageable pageable);
}
