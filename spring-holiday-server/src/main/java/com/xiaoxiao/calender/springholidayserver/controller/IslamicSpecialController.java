package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.IslamicSpecial;
import com.xiaoxiao.calender.springholidayserver.repository.IslamicSpecialRepository;
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
public class IslamicSpecialController {
    @Autowired
    IslamicSpecialRepository repository;

    /**
     * @return all islamicSpecials object exist in the database
     */
    @GetMapping("/islamicspecial")
    public List<IslamicSpecial> getAllIslamicSpecial(){
        List<IslamicSpecial> islamicSpecials = new ArrayList<>();
        repository.findAll().forEach(islamicSpecials::add);

        return islamicSpecials;
    }

    @RequestMapping(value = "/islamicspecial/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<IslamicSpecial> create(@RequestBody IslamicSpecial islamicSpecials) {
        IslamicSpecial _islamicSpecials = islamicSpecials;
        _islamicSpecials.setDay(islamicSpecials.getDay());
        _islamicSpecials.setMonth(islamicSpecials.getMonth());
        _islamicSpecials.setOffset(islamicSpecials.getOffset());
        _islamicSpecials.setDescription(islamicSpecials.getDescription());
        repository.save(_islamicSpecials);
        List<IslamicSpecial> islamicSpecialss = new ArrayList<>();
        repository.findAll().forEach(islamicSpecialss::add);

        return islamicSpecialss;
        // return service.create(resource);
    }


    @PutMapping("/islamicspecial/update/{id}")
    public ResponseEntity<IslamicSpecial> updateIslamicSpecial(@PathVariable("id") long id, @RequestBody IslamicSpecial islamicSpecials) {
        System.out.println("Update IslamicSpecial with ID = " + id + "...");

        Optional<IslamicSpecial> islamicSpecialsData = repository.findById(id);
        if (islamicSpecialsData.isPresent()) {
            IslamicSpecial _islamicSpecials = islamicSpecialsData.get();
            _islamicSpecials.setDay(islamicSpecials.getDay());
            _islamicSpecials.setMonth(islamicSpecials.getMonth());
            _islamicSpecials.setOffset(islamicSpecials.getOffset());
            _islamicSpecials.setDescription(islamicSpecials.getDescription());


            return new ResponseEntity<>(repository.save(_islamicSpecials), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/islamicspecial/search", method = RequestMethod.POST)
    @ResponseBody
    public List<IslamicSpecial> getSearch(@RequestBody IslamicSpecial islamicSpecial){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<IslamicSpecial> example = Example.of(islamicSpecial, matcher);

        List<IslamicSpecial> islamicSpecials = new ArrayList<>();
        repository.findAll(example).forEach(islamicSpecials::add);
        return islamicSpecials;
    }

    @DeleteMapping("/islamicspecial/{id}")
    public ResponseEntity<String> deleteIslamicSpecial(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("IslamicSpecial has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/islamicspecial/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedIslamicSpecial(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/islamicspecial/fields")
    public String[] getFields(){
        return Arrays.stream(IslamicSpecial.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
