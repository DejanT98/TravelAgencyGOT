package got.backend.controllers;

import got.backend.model.Country;
import got.backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> listAll() {
        List<Country> listStudents = countryRepository.findAll();

        return listStudents;
    }

}
