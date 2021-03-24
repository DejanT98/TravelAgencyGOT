package got.backend.controllers;

import got.backend.model.Destination;
import got.backend.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/destinations")
public class DestinationController {
    @Autowired
    private DestinationRepository destinationRepository;

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable("id") Integer id) {
        if(!destinationRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Destination destination = destinationRepository.getOne(id);
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        destinationRepository.save(destination);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable("id") Integer id,
                                                         @RequestBody Destination destination) {
        if(!destinationRepository.existsById(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        destination.setId(id);
        destinationRepository.save(destination);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
