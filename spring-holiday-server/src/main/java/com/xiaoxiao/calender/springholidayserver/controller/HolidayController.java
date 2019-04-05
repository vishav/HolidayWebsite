package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.xiaoxiao.calender.springholidayserver.repository.HolidayRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HolidayController {

    @Autowired
    HolidayRepository repository;

    /**
     * @return all holidays object exist in the database
     */
    @GetMapping("/holidays")
    public List<Holiday> getAllHolidays(){
        List<Holiday> holidays = new ArrayList<>();
        repository.findAll().forEach(holidays::add);

        return holidays;
    }

    /**
     * @return all holidays object match for search para
     */
    @RequestMapping(value ="/holidays/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Holiday> getSearchHolidaysLocalesDetails(@RequestBody Holiday holiday){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<Holiday> example = Example.of(holiday, matcher);

        List<Holiday> holidays = new ArrayList<>();
        repository.findAll(example).forEach(holidays::add);

        return holidays;
    }


    @PutMapping("/holidays/update/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable("id") long id, @RequestBody Holiday holiday) {
        System.out.println("Update Holiday with ID = " + id + "...");

        Optional<Holiday> holidayData = repository.findById(id);

        if (holidayData.isPresent()) {
            Holiday _holiday = holidayData.get();
            _holiday.setName(holiday.getName());

            return new ResponseEntity<>(repository.save(_holiday), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/holidays/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Holiday> create(@RequestBody Holiday Holiday) {

        repository.save(new Holiday(Holiday.getName()));
        List<Holiday> holidays = new ArrayList<>();
        repository.findAll().forEach(holidays::add);

        return holidays;
       // return service.create(resource);
    }

    @DeleteMapping("/holidays/{id}")
    public ResponseEntity<String> deleteHolidays(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Holidays has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/holidays/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHolidays(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("Holidays has been deleted!", HttpStatus.OK);
    }



    @GetMapping("holidays/fields")
    public String[] getFields(){
        return Arrays.stream(Holiday.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
