package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.HolidaysLocalesDetails;
import com.xiaoxiao.calender.springholidayserver.repository.HolidaysLocalesDetailsRepository;
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
public class HolidaysLocalesDetailsController {

    @Autowired
    HolidaysLocalesDetailsRepository repository;

    /**
     * @return all holidaysLocaleDetailss object exist in the database
     */
    @GetMapping("/holidaysLocalesDetails")
    public List<HolidaysLocalesDetails> getAllHolidaysLocalesDetails(){
        List<HolidaysLocalesDetails> holidaysLocaleDetailss = new ArrayList<>();
        repository.findAll().forEach(holidaysLocaleDetailss::add);
        System.out.println("from add "+holidaysLocaleDetailss.size());
        return holidaysLocaleDetailss;
    }

    /**
     * @return all holidaysLocaleDetailss object match for search para
     */
    @RequestMapping(value ="/holidaysLocalesDetails/search", method = RequestMethod.POST)
    @ResponseBody
    public List<HolidaysLocalesDetails> getSearchHolidaysLocalesDetails(@RequestBody HolidaysLocalesDetails holidaysLocalesDetails){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<HolidaysLocalesDetails> example = Example.of(holidaysLocalesDetails, matcher);

        List<HolidaysLocalesDetails> holidaysLocaleDetailss = new ArrayList<>();
        repository.findAll(example).forEach(holidaysLocaleDetailss::add);

        return holidaysLocaleDetailss;
    }

    @GetMapping("/holidaysLocalesDetails/fields")
    public String[] customFindMethod(){
        String[] fields = HolidaysLocalesDetails.getFields();
        return fields;
    }

    @RequestMapping(value = "/holidaysLocalesDetails/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<HolidaysLocalesDetails> create(@RequestBody HolidaysLocalesDetails holidaysLocalesDetails) {
        /*
        HolidaysLocalesDetails holidaysLocalesDetails1 =
                new HolidaysLocalesDetails(holidaysLocalesDetails); */
        repository.save(holidaysLocalesDetails);
        List<HolidaysLocalesDetails> holidays = new ArrayList<>();
        repository.findAll().forEach(holidays::add);
        System.out.println("from create "+ holidays.size());
        return holidays;
    }

    @PutMapping("/holidaysLocalesDetails/update/{id}")
    public ResponseEntity<HolidaysLocalesDetails> updateHolidaysLocalesDetails(@PathVariable("id") long id,@RequestBody HolidaysLocalesDetails holidaysLocaleDetails) {
        System.out.println("Update HolidaysLocalesDetails , " +
                " holiday = " + holidaysLocaleDetails.getHoliday() +
                " holiday state = "+holidaysLocaleDetails.getCountry());

        Optional<HolidaysLocalesDetails> holidaysLocaleDetailsData = repository.findById(id);

        if (holidaysLocaleDetailsData.isPresent()) {

            return new ResponseEntity<>(repository.save(holidaysLocaleDetails), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/holidaysLocalesDetails/{id}")
    public ResponseEntity<String> deleteHolidaysLocalesDetailss(@PathVariable Long id) {
        System.out.println("the locale record to be delete "+id);
        repository.deleteById(id);
        return new ResponseEntity<>("HolidaysLocalesDetailss has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/holidaysLocalesDetails/delete-requests")
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHolidaysLocalesDetails(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("Holidays has been deleted!", HttpStatus.OK);
    }

}
