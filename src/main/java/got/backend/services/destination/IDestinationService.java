package got.backend.services.destination;

import got.backend.model.Accommodation;
import got.backend.model.Destination;
import got.backend.services.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDestinationService extends IService<Destination> {
    List<Destination> getDestinationsByCountryName(String name);

    Page<Destination> findAll(Pageable pageable);
}
