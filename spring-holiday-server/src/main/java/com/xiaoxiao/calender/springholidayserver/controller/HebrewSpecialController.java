package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.HebrewSpecial;
import com.xiaoxiao.calender.springholidayserver.repository.HebrewSpecialRepository;
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
public class HebrewSpecialController {
    @Autowired
    HebrewSpecialRepository repository;

    /**
     * @return all hebrewSpecials object exist in the database
     */
    @GetMapping("/hebrewspecial")
    public List<HebrewSpecial> getAllHebrewSpecial(){
        List<HebrewSpecial> hebrewSpecials = new ArrayList<>();
        repository.findAll().forEach(hebrewSpecials::add);

        return hebrewSpecials;
    }

    @RequestMapping(value = "/hebrewspecial/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<HebrewSpecial> create(@RequestBody HebrewSpecial hebrewSpecials) {
        HebrewSpecial _hebrewSpecials = hebrewSpecials;
        _hebrewSpecials.setDay(hebrewSpecials.getDay());
        _hebrewSpecials.setMonth(hebrewSpecials.getMonth());
        _hebrewSpecials.setOffset(hebrewSpecials.getOffset());
        _hebrewSpecials.setDescription(hebrewSpecials.getDescription());
        repository.save(_hebrewSpecials);
        List<HebrewSpecial> hebrewSpecialss = new ArrayList<>();
        repository.findAll().forEach(hebrewSpecialss::add);

        return hebrewSpecialss;
        // return service.create(resource);
    }


    @PutMapping("/hebrewspecial/update/{id}")
    public ResponseEntity<HebrewSpecial> updateHebrewSpecial(@PathVariable("id") long id, @RequestBody HebrewSpecial hebrewSpecials) {
        System.out.println("Update HebrewSpecial with ID = " + id + "...");

        Optional<HebrewSpecial> hebrewSpecialsData = repository.findById(id);
        if (hebrewSpecialsData.isPresent()) {
            HebrewSpecial _hebrewSpecials = hebrewSpecialsData.get();
            _hebrewSpecials.setDay(hebrewSpecials.getDay());
            _hebrewSpecials.setMonth(hebrewSpecials.getMonth());
            _hebrewSpecials.setOffset(hebrewSpecials.getOffset());
            _hebrewSpecials.setDescription(hebrewSpecials.getDescription());


            return new ResponseEntity<>(repository.save(_hebrewSpecials), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/hebrewspecial/search", method = RequestMethod.POST)
    @ResponseBody
    public List<HebrewSpecial> getSearch(@RequestBody HebrewSpecial hebrewSpecial){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<HebrewSpecial> example = Example.of(hebrewSpecial, matcher);

        List<HebrewSpecial> hebrewSpecials = new ArrayList<>();
        repository.findAll(example).forEach(hebrewSpecials::add);
        return hebrewSpecials;
    }

    @DeleteMapping("/hebrewspecial/{id}")
    public ResponseEntity<String> deleteHebrewSpecial(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("HebrewSpecial has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/hebrewspecial/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHebrewSpecial(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/hebrewspecial/fields")
    public String[] getFields(){
        return Arrays.stream(HebrewSpecial.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
