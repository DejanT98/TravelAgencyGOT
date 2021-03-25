package got.backend.controllers;

import got.backend.model.Accommodation;
import got.backend.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/accommodation")
public class AccommodationController {
    @Autowired
    private AccommodationRepository accommodationRepository;

    @GetMapping
    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getAccommodationById(@PathVariable("id") Integer id) {
        if(!accommodationRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Accommodation accommodation = accommodationRepository.getOne(id);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {
        accommodationRepository.save(accommodation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable("id") Integer id,
                                                             @RequestBody Accommodation accommodation) {
        if(!accommodationRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        accommodation.setId(id);
        accommodationRepository.save(accommodation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
