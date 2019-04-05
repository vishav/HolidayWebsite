package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.GregorianMonthdayMoonphase;
import com.xiaoxiao.calender.springholidayserver.repository.GregorianMonthdayMoonphaseRepository;
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
public class GregorianMonthdayMoonphaseController {
    @Autowired
    GregorianMonthdayMoonphaseRepository repository;

    /**
     * @return all gregorianMonthdayMoonphases object exist in the database
     */
    @GetMapping("/gregorianmonthdaymoonphase")
    public List<GregorianMonthdayMoonphase> getAllGregorianMonthdayMoonphase(){
        List<GregorianMonthdayMoonphase> gregorianMonthdayMoonphases = new ArrayList<>();
        repository.findAll().forEach(gregorianMonthdayMoonphases::add);

        return gregorianMonthdayMoonphases;
    }

    @RequestMapping(value = "/gregorianmonthdaymoonphase/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<GregorianMonthdayMoonphase> create(@RequestBody GregorianMonthdayMoonphase gregorianMonthdayMoonphases) {
        GregorianMonthdayMoonphase _gregorianMonthdayMoonphases = gregorianMonthdayMoonphases;
        _gregorianMonthdayMoonphases.setDay(gregorianMonthdayMoonphases.getDay());
        repository.save(_gregorianMonthdayMoonphases);
        List<GregorianMonthdayMoonphase> gregorianMonthdayMoonphasess = new ArrayList<>();
        repository.findAll().forEach(gregorianMonthdayMoonphasess::add);

        return gregorianMonthdayMoonphasess;
        // return service.create(resource);
    }


    @PutMapping("/gregorianmonthdaymoonphase/update/{id}")
    public ResponseEntity<GregorianMonthdayMoonphase> updateGregorianMonthdayMoonphase(@PathVariable("id") long id, @RequestBody GregorianMonthdayMoonphase gregorianMonthdayMoonphases) {
        System.out.println("Update GregorianMonthdayMoonphase with ID = " + id + "...");

        Optional<GregorianMonthdayMoonphase> gregorianMonthdayMoonphasesData = repository.findById(id);
        if (gregorianMonthdayMoonphasesData.isPresent()) {
            GregorianMonthdayMoonphase _gregorianMonthdayMoonphases = gregorianMonthdayMoonphasesData.get();
            _gregorianMonthdayMoonphases.setDay(gregorianMonthdayMoonphases.getDay());
            _gregorianMonthdayMoonphases.setLocation(gregorianMonthdayMoonphases.getLocation());
            _gregorianMonthdayMoonphases.setMonth(gregorianMonthdayMoonphases.getMonth());
            _gregorianMonthdayMoonphases.setMoonphase(gregorianMonthdayMoonphases.getMoonphase());
            _gregorianMonthdayMoonphases.setOffset(gregorianMonthdayMoonphases.getOffset());


            return new ResponseEntity<>(repository.save(_gregorianMonthdayMoonphases), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/gregorianmonthdaymoonphase/search", method = RequestMethod.POST)
    @ResponseBody
    public List<GregorianMonthdayMoonphase> getSearch(@RequestBody GregorianMonthdayMoonphase gregorianMonthdayMoonphase){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<GregorianMonthdayMoonphase> example = Example.of(gregorianMonthdayMoonphase, matcher);

        List<GregorianMonthdayMoonphase> gregorianMonthdayMoonphases = new ArrayList<>();
        repository.findAll(example).forEach(gregorianMonthdayMoonphases::add);
        return gregorianMonthdayMoonphases;
    }

    @DeleteMapping("/gregorianmonthdaymoonphase/{id}")
    public ResponseEntity<String> deleteGregorianMonthdayMoonphase(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("GregorianMonthdayMoonphase has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/gregorianmonthdaymoonphase/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedGregorianMonthdayMoonphase(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/gregorianmonthdaymoonphase/fields")
    public String[] getFields(){
        return Arrays.stream(GregorianMonthdayMoonphase.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
