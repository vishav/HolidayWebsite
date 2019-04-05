package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.GregorianMonthday;
import com.xiaoxiao.calender.springholidayserver.repository.GregorianMonthdayRepository;
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
public class GregorianMonthdayController {
    @Autowired
    GregorianMonthdayRepository repository;

    /**
     * @return all gregorianMonthdays object exist in the database
     */
    @GetMapping("/gregorianmonthday")
    public List<GregorianMonthday> getAllGregorianMonthday(){
        List<GregorianMonthday> gregorianMonthdays = new ArrayList<>();
        repository.findAll().forEach(gregorianMonthdays::add);

        return gregorianMonthdays;
    }

    @RequestMapping(value = "/gregorianmonthday/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<GregorianMonthday> create(@RequestBody GregorianMonthday gregorianMonthdays) {
        GregorianMonthday _gregorianMonthdays = gregorianMonthdays;
        _gregorianMonthdays.setDay(gregorianMonthdays.getDay());
        _gregorianMonthdays.setLeapyearadjust(gregorianMonthdays.getLeapyearadjust());
        _gregorianMonthdays.setMonth(gregorianMonthdays.getMonth());
        _gregorianMonthdays.setOffset(gregorianMonthdays.getOffset());
        repository.save(_gregorianMonthdays);
        List<GregorianMonthday> gregorianMonthdayss = new ArrayList<>();
        repository.findAll().forEach(gregorianMonthdayss::add);

        return gregorianMonthdayss;
        // return service.create(resource);
    }


    @PutMapping("/gregorianmonthday/update/{id}")
    public ResponseEntity<GregorianMonthday> updateGregorianMonthday(@PathVariable("id") long id, @RequestBody GregorianMonthday gregorianMonthdays) {
        System.out.println("Update GregorianMonthday with ID = " + id + "...");

        Optional<GregorianMonthday> gregorianMonthdaysData = repository.findById(id);
        if (gregorianMonthdaysData.isPresent()) {
            GregorianMonthday _gregorianMonthdays = gregorianMonthdaysData.get();
            _gregorianMonthdays.setDay(gregorianMonthdays.getDay());
            _gregorianMonthdays.setLeapyearadjust(gregorianMonthdays.getLeapyearadjust());
            _gregorianMonthdays.setMonth(gregorianMonthdays.getMonth());
            _gregorianMonthdays.setOffset(gregorianMonthdays.getOffset());


            return new ResponseEntity<>(repository.save(_gregorianMonthdays), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/gregorianmonthday/search", method = RequestMethod.POST)
    @ResponseBody
    public List<GregorianMonthday> getSearch(@RequestBody GregorianMonthday gregorianMonthday){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<GregorianMonthday> example = Example.of(gregorianMonthday, matcher);

        List<GregorianMonthday> gregorianMonthdays = new ArrayList<>();
        repository.findAll(example).forEach(gregorianMonthdays::add);
        return gregorianMonthdays;
    }

    @DeleteMapping("/gregorianmonthday/{id}")
    public ResponseEntity<String> deleteGregorianMonthday(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("GregorianMonthday has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/gregorianmonthday/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedGregorianMonthday(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/gregorianmonthday/fields")
    public String[] getFields(){
        return Arrays.stream(GregorianMonthday.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
