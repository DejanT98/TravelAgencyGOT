package got.backend.services.destination;

import got.backend.model.Destination;
import got.backend.services.IService;

import java.util.List;

public interface IDestinationService extends IService<Destination> {
    List<Destination> getDestinationsByCountryName(String name);
}
