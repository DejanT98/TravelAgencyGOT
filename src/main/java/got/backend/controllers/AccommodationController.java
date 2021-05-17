package got.backend.controllers;

import got.backend.model.Accommodation;
import got.backend.model.Country;
import got.backend.repository.AccommodationRepository;
import got.backend.services.accommodation.IAccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/accommodation")
public class AccommodationController {
    @Autowired
    private IAccommodationService accommodationService;

    @GetMapping
    public Page<Accommodation> getAllAccommodations(Pageable pageable) {
        return accommodationService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getAccommodationById(@PathVariable("id") Integer id) {
        Accommodation accommodation = accommodationService.findById(id);
        if(accommodation == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Accommodation> createAccommodation(@RequestBody Accommodation accommodation) {
        accommodationService.save(accommodation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> updateAccommodation(@PathVariable("id") Integer id,
                                                             @RequestBody Accommodation accommodation) {
        boolean success = accommodationService.updateById(id, accommodation);
        if(!success)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        accommodation.setId(id);
        accommodationService.save(accommodation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Accommodation> deleteAccommodation(@PathVariable("id") Integer id) {
        boolean success = accommodationService.deleteById(id);
        if(!success) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
