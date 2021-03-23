package got.backend.controllers;

import got.backend.model.Country;
import got.backend.repository.CountryRepository;
import got.backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable("id") Integer id) {
        System.out.println(id);
        return countryRepository.getOne(id);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country c = countryRepository.save(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable("id")Integer id,
                                                 @RequestBody Country country) {
        Country c = countryRepository.getOne(id);
        if(c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        country.setId(id);
        countryRepository.save(country);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable("id") Integer id) {
        Country c = countryRepository.getOne(id);
        if(c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
