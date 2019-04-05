package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.Country;
import com.xiaoxiao.calender.springholidayserver.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    CountryRepository repository;
    /**
     * @return all countrys object exist in the database
     */
    @GetMapping("/country")
    public List<Country> getAllCountrys(){
        List<Country> countrys = new ArrayList<>();
        repository.findAll().forEach(countrys::add);

        return countrys;
    }


    @RequestMapping(value ="/country/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Country> getSearch(@RequestBody Country country){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<Country> example = Example.of(country, matcher);
        //Iterable<HolidaysLocalesDetails> holidaysLocaleDetailsList = repository.findAll(example) ;
        // repository.findAll(cities)
        List<Country> countries = new ArrayList<>();
        repository.findAll(example).forEach(countries::add);

        return countries;
    }

    @PutMapping("/country/update/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable("id") long id, @RequestBody Country country) {
        System.out.println("Update Country with ID = " + id + "...");

        Optional<Country> countryData = repository.findById(id);

        if (countryData.isPresent()) {
            Country _country = countryData.get();
            _country.setName(country.getName());

            return new ResponseEntity<>(repository.save(_country), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/country/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Country> create(@RequestBody Country Country) {

        repository.save(new Country(Country.getName()));
        List<Country> countrys = new ArrayList<>();
        repository.findAll().forEach(countrys::add);

        return countrys;
        // return service.create(resource);
    }

    @DeleteMapping("/country/{id}")
    public ResponseEntity<String> deleteCountrys(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Countrys has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/country/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedCountry(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("Countries has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/country/fields")
    public String[] getFields(){
        return Arrays.stream(Country.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
