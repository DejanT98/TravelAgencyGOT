package got.backend.repository;

import got.backend.model.Country;
import got.backend.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Integer> {

    List<Destination> findDestinationsByCountry(Country country);
}
