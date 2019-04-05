package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.GregorianKdayafteretcMonthday;
import com.xiaoxiao.calender.springholidayserver.repository.GregorianKdayafteretcMonthdayRepository;
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
public class GregorianKdayafteretcMonthdayController {
    @Autowired
    GregorianKdayafteretcMonthdayRepository repository;

    /**
     * @return all gregorianKdayafteretcMonthdays object exist in the database
     */
    @GetMapping("/gregoriankdayafteretcmonthday")
    public List<GregorianKdayafteretcMonthday> getAllGregorianKdayafteretcMonthday(){
        List<GregorianKdayafteretcMonthday> gregorianKdayafteretcMonthdays = new ArrayList<>();
        repository.findAll().forEach(gregorianKdayafteretcMonthdays::add);

        return gregorianKdayafteretcMonthdays;
    }

    @RequestMapping(value = "/gregoriankdayafteretcmonthday/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<GregorianKdayafteretcMonthday> create(@RequestBody GregorianKdayafteretcMonthday gregorianKdayafteretcMonthdays) {
        GregorianKdayafteretcMonthday _gregorianKdayafteretcMonthdays = gregorianKdayafteretcMonthdays;
        _gregorianKdayafteretcMonthdays.setDay(gregorianKdayafteretcMonthdays.getDay());
        _gregorianKdayafteretcMonthdays.setKday(gregorianKdayafteretcMonthdays.getKday());
        _gregorianKdayafteretcMonthdays.setMonth(gregorianKdayafteretcMonthdays.getMonth());
        _gregorianKdayafteretcMonthdays.setOffset(gregorianKdayafteretcMonthdays.getOffset());
        _gregorianKdayafteretcMonthdays.setAfteretc(gregorianKdayafteretcMonthdays.getAfteretc());
        repository.save(_gregorianKdayafteretcMonthdays);
        List<GregorianKdayafteretcMonthday> gregorianKdayafteretcMonthdayss = new ArrayList<>();
        repository.findAll().forEach(gregorianKdayafteretcMonthdayss::add);

        return gregorianKdayafteretcMonthdayss;
        // return service.create(resource);
    }


    @PutMapping("/gregoriankdayafteretcmonthday/update/{id}")
    public ResponseEntity<GregorianKdayafteretcMonthday> updateGregorianKdayafteretcMonthday(@PathVariable("id") long id, @RequestBody GregorianKdayafteretcMonthday gregorianKdayafteretcMonthdays) {
        System.out.println("Update GregorianKdayafteretcMonthday with ID = " + id + "...");

        Optional<GregorianKdayafteretcMonthday> gregorianKdayafteretcMonthdaysData = repository.findById(id);
        if (gregorianKdayafteretcMonthdaysData.isPresent()) {
            GregorianKdayafteretcMonthday _gregorianKdayafteretcMonthdays = gregorianKdayafteretcMonthdaysData.get();
            _gregorianKdayafteretcMonthdays.setDay(gregorianKdayafteretcMonthdays.getDay());
            _gregorianKdayafteretcMonthdays.setKday(gregorianKdayafteretcMonthdays.getKday());
            _gregorianKdayafteretcMonthdays.setMonth(gregorianKdayafteretcMonthdays.getMonth());
            _gregorianKdayafteretcMonthdays.setOffset(gregorianKdayafteretcMonthdays.getOffset());
            _gregorianKdayafteretcMonthdays.setAfteretc(gregorianKdayafteretcMonthdays.getAfteretc());


            return new ResponseEntity<>(repository.save(_gregorianKdayafteretcMonthdays), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/gregoriankdayafteretcmonthday/search", method = RequestMethod.POST)
    @ResponseBody
    public List<GregorianKdayafteretcMonthday> getSearch(@RequestBody GregorianKdayafteretcMonthday gregorianKdayafteretcMonthday){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<GregorianKdayafteretcMonthday> example = Example.of(gregorianKdayafteretcMonthday, matcher);

        List<GregorianKdayafteretcMonthday> gregorianKdayafteretcMonthdays = new ArrayList<>();
        repository.findAll(example).forEach(gregorianKdayafteretcMonthdays::add);
        return gregorianKdayafteretcMonthdays;
    }

    @DeleteMapping("/gregoriankdayafteretcmonthday/{id}")
    public ResponseEntity<String> deleteGregorianKdayafteretcMonthday(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("GregorianKdayafteretcMonthday has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/gregoriankdayafteretcmonthday/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedGregorianKdayafteretcMonthday(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/gregoriankdayafteretcmonthday/fields")
    public String[] getFields(){
        return Arrays.stream(GregorianKdayafteretcMonthday.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
