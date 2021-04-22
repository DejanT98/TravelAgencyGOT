package got.backend.controllers;

import got.backend.model.Country;
import got.backend.services.country.ICountryService;
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
    private ICountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountries() {
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("id") Integer id) {
        Country country = countryService.findById(id);
        if(country == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        countryService.save(country);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable("id")Integer id,
                                                 @RequestBody Country country) {
        boolean success = countryService.updateById(id, country);
        if(!success)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable("id") Integer id) {
        boolean success = countryService.deleteById(id);
        if(!success) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
