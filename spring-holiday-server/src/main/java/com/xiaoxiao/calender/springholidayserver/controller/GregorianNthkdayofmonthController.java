package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.GregorianNthkdayofmonth;
import com.xiaoxiao.calender.springholidayserver.repository.GregorianNthkdayofmonthRepository;
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
public class GregorianNthkdayofmonthController {
    @Autowired
    GregorianNthkdayofmonthRepository repository;

    /**
     * @return all gregorianNthkdayofmonths object exist in the database
     */
    @GetMapping("/gregoriannthkdayofmonth")
    public List<GregorianNthkdayofmonth> getAllGregorianNthkdayofmonth(){
        List<GregorianNthkdayofmonth> gregorianNthkdayofmonths = new ArrayList<>();
        repository.findAll().forEach(gregorianNthkdayofmonths::add);

        return gregorianNthkdayofmonths;
    }

    @RequestMapping(value = "/gregoriannthkdayofmonth/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<GregorianNthkdayofmonth> create(@RequestBody GregorianNthkdayofmonth gregorianNthkdayofmonths) {
        GregorianNthkdayofmonth _gregorianNthkdayofmonths = gregorianNthkdayofmonths;
        _gregorianNthkdayofmonths.setOffset(gregorianNthkdayofmonths.getOffset());
        _gregorianNthkdayofmonths.setMonth(gregorianNthkdayofmonths.getMonth());
        _gregorianNthkdayofmonths.setKday(gregorianNthkdayofmonths.getKday());
        _gregorianNthkdayofmonths.setNth(gregorianNthkdayofmonths.getNth());
        repository.save(_gregorianNthkdayofmonths);
        List<GregorianNthkdayofmonth> gregorianNthkdayofmonthss = new ArrayList<>();
        repository.findAll().forEach(gregorianNthkdayofmonthss::add);

        return gregorianNthkdayofmonthss;
        // return service.create(resource);
    }


    @PutMapping("/gregoriannthkdayofmonth/update/{id}")
    public ResponseEntity<GregorianNthkdayofmonth> updateGregorianNthkdayofmonth(@PathVariable("id") long id, @RequestBody GregorianNthkdayofmonth gregorianNthkdayofmonths) {
        System.out.println("Update GregorianNthkdayofmonth with ID = " + id + "...");

        Optional<GregorianNthkdayofmonth> gregorianNthkdayofmonthsData = repository.findById(id);
        if (gregorianNthkdayofmonthsData.isPresent()) {
            GregorianNthkdayofmonth _gregorianNthkdayofmonths = gregorianNthkdayofmonthsData.get();
            _gregorianNthkdayofmonths.setOffset(gregorianNthkdayofmonths.getOffset());
            _gregorianNthkdayofmonths.setMonth(gregorianNthkdayofmonths.getMonth());
            _gregorianNthkdayofmonths.setKday(gregorianNthkdayofmonths.getKday());
            _gregorianNthkdayofmonths.setNth(gregorianNthkdayofmonths.getNth());


            return new ResponseEntity<>(repository.save(_gregorianNthkdayofmonths), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/gregoriannthkdayofmonth/search", method = RequestMethod.POST)
    @ResponseBody
    public List<GregorianNthkdayofmonth> getSearch(@RequestBody GregorianNthkdayofmonth gregorianNthkdayofmonth){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<GregorianNthkdayofmonth> example = Example.of(gregorianNthkdayofmonth, matcher);

        List<GregorianNthkdayofmonth> gregorianNthkdayofmonths = new ArrayList<>();
        repository.findAll(example).forEach(gregorianNthkdayofmonths::add);
        return gregorianNthkdayofmonths;
    }

    @DeleteMapping("/gregoriannthkdayofmonth/{id}")
    public ResponseEntity<String> deleteGregorianNthkdayofmonth(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("GregorianNthkdayofmonth has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/gregoriannthkdayofmonth/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedGregorianNthkdayofmonth(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/gregoriannthkdayofmonth/fields")
    public String[] getFields(){
        return Arrays.stream(GregorianNthkdayofmonth.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
