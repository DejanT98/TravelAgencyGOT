package got.backend.controllers;

import got.backend.model.Country;
import got.backend.model.Offer;
import got.backend.repository.OfferRepository;
import got.backend.services.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> getAllCountries() {
        return offerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Integer id) {
        Offer offer = offerService.findById(id);
        if(offer == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        offerService.save(offer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable("id")Integer id,
                                                 @RequestBody Offer offer) {
        boolean success = offerService.updateById(id, offer);
        if(!success)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        offer.setId(id);
        offerService.save(offer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Offer> deleteOffer(@PathVariable("id") Integer id) {
        boolean success = offerService.deleteById(id);
        if(!success) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
