package got.backend.controllers;

import got.backend.model.Country;
import got.backend.model.Destination;
import got.backend.repository.DestinationRepository;
import got.backend.services.destination.IDestinationService;
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
    private IDestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        return new ResponseEntity<>(destinationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable("id") Integer id) {
        Destination destination = destinationService.findById(id);
        if(destination == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<Destination>> getDestinationByCountry(@PathVariable("countryName") String countryName) {
        List<Destination> destinations = destinationService.getDestinationsByCountryName(countryName.toLowerCase());
        if(destinations == null || destinations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        destinationService.save(destination);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable("id") Integer id,
                                                         @RequestBody Destination destination) {
        boolean success = destinationService.updateById(id, destination);
        if(!success) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        destination.setId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
