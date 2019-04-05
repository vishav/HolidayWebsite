package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.GregorianMonthdaySpecial;
import com.xiaoxiao.calender.springholidayserver.repository.GregorianMonthdaySpecialRepository;
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
public class GregorianMonthdaySpecialController {
    @Autowired
    GregorianMonthdaySpecialRepository repository;

    /**
     * @return all gregorianMonthdaySpecials object exist in the database
     */
    @GetMapping("/gregorianmonthdayspecial")
    public List<GregorianMonthdaySpecial> getAllGregorianMonthdaySpecial(){
        List<GregorianMonthdaySpecial> gregorianMonthdaySpecials = new ArrayList<>();
        repository.findAll().forEach(gregorianMonthdaySpecials::add);

        return gregorianMonthdaySpecials;
    }

    @RequestMapping(value = "/gregorianmonthdayspecial/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<GregorianMonthdaySpecial> create(@RequestBody GregorianMonthdaySpecial gregorianMonthdaySpecials) {
        GregorianMonthdaySpecial _gregorianMonthdaySpecials = gregorianMonthdaySpecials;
        _gregorianMonthdaySpecials.setDay(gregorianMonthdaySpecials.getDay());
        _gregorianMonthdaySpecials.setLeapyearadjust(gregorianMonthdaySpecials.getLeapyearadjust());
        _gregorianMonthdaySpecials.setMonth(gregorianMonthdaySpecials.getMonth());
        _gregorianMonthdaySpecials.setOffset(gregorianMonthdaySpecials.getOffset());
        _gregorianMonthdaySpecials.setDescription(gregorianMonthdaySpecials.getDescription());
        repository.save(_gregorianMonthdaySpecials);
        List<GregorianMonthdaySpecial> gregorianMonthdaySpecialss = new ArrayList<>();
        repository.findAll().forEach(gregorianMonthdaySpecialss::add);

        return gregorianMonthdaySpecialss;
        // return service.create(resource);
    }


    @PutMapping("/gregorianmonthdayspecial/update/{id}")
    public ResponseEntity<GregorianMonthdaySpecial> updateGregorianMonthdaySpecial(@PathVariable("id") long id, @RequestBody GregorianMonthdaySpecial gregorianMonthdaySpecials) {
        System.out.println("Update GregorianMonthdaySpecial with ID = " + id + "...");

        Optional<GregorianMonthdaySpecial> gregorianMonthdaySpecialsData = repository.findById(id);
        if (gregorianMonthdaySpecialsData.isPresent()) {
            GregorianMonthdaySpecial _gregorianMonthdaySpecials = gregorianMonthdaySpecialsData.get();
            _gregorianMonthdaySpecials.setDay(gregorianMonthdaySpecials.getDay());
            _gregorianMonthdaySpecials.setLeapyearadjust(gregorianMonthdaySpecials.getLeapyearadjust());
            _gregorianMonthdaySpecials.setMonth(gregorianMonthdaySpecials.getMonth());
            _gregorianMonthdaySpecials.setOffset(gregorianMonthdaySpecials.getOffset());
            _gregorianMonthdaySpecials.setDescription(gregorianMonthdaySpecials.getDescription());


            return new ResponseEntity<>(repository.save(_gregorianMonthdaySpecials), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/gregorianmonthdayspecial/search", method = RequestMethod.POST)
    @ResponseBody
    public List<GregorianMonthdaySpecial> getSearch(@RequestBody GregorianMonthdaySpecial gregorianMonthdaySpecial){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<GregorianMonthdaySpecial> example = Example.of(gregorianMonthdaySpecial, matcher);

        List<GregorianMonthdaySpecial> gregorianMonthdaySpecials = new ArrayList<>();
        repository.findAll(example).forEach(gregorianMonthdaySpecials::add);
        return gregorianMonthdaySpecials;
    }

    @DeleteMapping("/gregorianmonthdayspecial/{id}")
    public ResponseEntity<String> deleteGregorianMonthdaySpecial(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("GregorianMonthdaySpecial has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/gregorianmonthdayspecial/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedGregorianMonthdaySpecial(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/gregorianmonthdayspecial/fields")
    public String[] getFields(){
        return Arrays.stream(GregorianMonthdaySpecial.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
