package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.City;
import com.xiaoxiao.calender.springholidayserver.repository.CityRepository;
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
public class CityController  {
    @Autowired
    CityRepository repository;
    /**
     * @return all citys object exist in the database
     */
    @GetMapping("/city")
    public List<City> getAllCitys(){
        List<City> cities = new ArrayList<>();
        repository.findAll().forEach(cities::add);
        return cities;
    }

    @PutMapping("/city/update/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") long id, @RequestBody City city) {
        System.out.println("Update City with ID = " + id + "...");

        Optional<City> cityData = repository.findById(id);

        if (cityData.isPresent()) {
            City _city = cityData.get();
            _city.setName(city.getName());
            _city.setCountry(city.getCountry());
            _city.setState(city.getState());
            return new ResponseEntity<>(repository.save(_city), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/city/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<City> create(@RequestBody City city) {
        City _city = city;
        _city.setName(city.getName());
        _city.setCountry(city.getCountry());
        _city.setState(city.getState());
        repository.save(_city);
        List<City> citys = new ArrayList<>();
        repository.findAll().forEach(citys::add);

        return citys;
        // return service.create(resource);
    }

    /**
     * @return all object match for search para
     */
    @RequestMapping(value ="/city/search", method = RequestMethod.POST)
    @ResponseBody
    public List<City> getSearch(@RequestBody City city){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<City> example = Example.of(city, matcher);
        List<City> cities = new ArrayList<>();
        repository.findAll(example).forEach(cities::add);

        return cities;
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Citys has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/city/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedCities(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/city/fields")
    public String[] getFields(){
        return Arrays.stream(City.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
