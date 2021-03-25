package got.backend.repository;

import got.backend.model.Country;
import got.backend.model.Destination;
import got.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DestinationRepository extends JpaRepository<Destination, Integer> {

    @Query("select d " +
            "from Destination d inner join d.country c " +
            "where LOWER(c.name) like :name")
    List<Destination> getDestinationsByCountryName(String name);

}
