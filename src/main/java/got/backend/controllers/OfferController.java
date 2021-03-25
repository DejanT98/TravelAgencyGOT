package got.backend.controllers;

import got.backend.model.Offer;
import got.backend.repository.OfferRepository;
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
    private OfferRepository offerRepository;

    @GetMapping
    public List<Offer> getAllCountries() {
        return offerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") Integer id) {
        if(!offerRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Offer offer = offerRepository.getOne(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        offerRepository.save(offer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable("id")Integer id,
                                                 @RequestBody Offer offer) {
        if(!offerRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        offer.setId(id);
        offerRepository.save(offer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Offer> deleteOffer(@PathVariable("id") Integer id) {
        if(!offerRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        offerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
