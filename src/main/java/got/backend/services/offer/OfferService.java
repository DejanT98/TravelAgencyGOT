package got.backend.services.offer;

import got.backend.model.Country;
import got.backend.model.Offer;
import got.backend.repository.CountryRepository;
import got.backend.repository.OfferRepository;
import got.backend.services.GenericService;
import got.backend.services.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService extends GenericService<Offer> implements IOfferService {

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        super(offerRepository);
    }
}
