package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.Hebrew;
import com.xiaoxiao.calender.springholidayserver.repository.HebrewRepository;
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
public class HebrewController {
    @Autowired
    HebrewRepository repository;

    /**
     * @return all hebrews object exist in the database
     */
    @GetMapping("/hebrew")
    public List<Hebrew> getAllHebrew(){
        List<Hebrew> hebrews = new ArrayList<>();
        repository.findAll().forEach(hebrews::add);

        return hebrews;
    }

    @RequestMapping(value = "/hebrew/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Hebrew> create(@RequestBody Hebrew hebrews) {
        Hebrew _hebrews = hebrews;
        _hebrews.setDay(hebrews.getDay());
        _hebrews.setMonth(hebrews.getMonth());
        _hebrews.setOffset(hebrews.getOffset());
        repository.save(_hebrews);
        List<Hebrew> hebrewss = new ArrayList<>();
        repository.findAll().forEach(hebrewss::add);

        return hebrewss;
        // return service.create(resource);
    }


    @PutMapping("/hebrew/update/{id}")
    public ResponseEntity<Hebrew> updateHebrew(@PathVariable("id") long id, @RequestBody Hebrew hebrews) {
        System.out.println("Update Hebrew with ID = " + id + "...");

        Optional<Hebrew> hebrewsData = repository.findById(id);
        if (hebrewsData.isPresent()) {
            Hebrew _hebrews = hebrewsData.get();
            _hebrews.setDay(hebrews.getDay());
            _hebrews.setMonth(hebrews.getMonth());
            _hebrews.setOffset(hebrews.getOffset());


            return new ResponseEntity<>(repository.save(_hebrews), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/hebrew/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Hebrew> getSearch(@RequestBody Hebrew hebrew){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<Hebrew> example = Example.of(hebrew, matcher);

        List<Hebrew> hebrews = new ArrayList<>();
        repository.findAll(example).forEach(hebrews::add);
        return hebrews;
    }

    @DeleteMapping("/hebrew/{id}")
    public ResponseEntity<String> deleteHebrew(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Hebrew has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/hebrew/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHebrew(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/hebrew/fields")
    public String[] getFields(){
        return Arrays.stream(Hebrew.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
