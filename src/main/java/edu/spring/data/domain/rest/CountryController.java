package edu.spring.data.domain.rest;

import edu.spring.data.domain.entity.Country;
import edu.spring.data.domain.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/country/all")
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @GetMapping("/country/{id}")
    public Country get(@PathVariable("id") Integer id) {
        return countryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "country by id " + id + "does not exist"));
    }

    @PutMapping("/country/{id}")
    public Country update(@PathVariable("id") Integer id, @RequestBody Country country) {
        Country dbCountry = countryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "country by id " + id + "does not exist"));

        dbCountry.setName(country.getName());
        dbCountry.setPopulation(country.getPopulation());

        return countryRepository.save(dbCountry);
    }

    @PostMapping("/country/add")
    public Country add(@RequestBody Country country) {
        return countryRepository.save(new Country(country.getName(), country.getPopulation()));
    }

    @DeleteMapping("/country/{id}")
    public ResponseEntity<Country> delete(@PathVariable("id") Integer id) {
        Country dbCountry =  countryRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "country by id " + id + "does not exist"));

        countryRepository.delete(dbCountry);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
