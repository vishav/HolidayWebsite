package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.Islamic;
import com.xiaoxiao.calender.springholidayserver.repository.IslamicRepository;
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
public class IslamicController {
    @Autowired
    IslamicRepository repository;

    /**
     * @return all islamics object exist in the database
     */
    @GetMapping("/islamic")
    public List<Islamic> getAllIslamic(){
        List<Islamic> islamics = new ArrayList<>();
        repository.findAll().forEach(islamics::add);

        return islamics;
    }

    @RequestMapping(value = "/islamic/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Islamic> create(@RequestBody Islamic islamics) {
        Islamic _islamics = islamics;
        _islamics.setDay(islamics.getDay());
        _islamics.setMonth(islamics.getMonth());
        _islamics.setOffset(islamics.getOffset());
        repository.save(_islamics);
        List<Islamic> islamicss = new ArrayList<>();
        repository.findAll().forEach(islamicss::add);

        return islamicss;
        // return service.create(resource);
    }


    @PutMapping("/islamic/update/{id}")
    public ResponseEntity<Islamic> updateIslamic(@PathVariable("id") long id, @RequestBody Islamic islamics) {
        System.out.println("Update Islamic with ID = " + id + "...");

        Optional<Islamic> islamicsData = repository.findById(id);
        if (islamicsData.isPresent()) {
            Islamic _islamics = islamicsData.get();
            _islamics.setDay(islamics.getDay());
            _islamics.setMonth(islamics.getMonth());
            _islamics.setOffset(islamics.getOffset());


            return new ResponseEntity<>(repository.save(_islamics), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/islamic/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Islamic> getSearch(@RequestBody Islamic islamic){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<Islamic> example = Example.of(islamic, matcher);

        List<Islamic> islamics = new ArrayList<>();
        repository.findAll(example).forEach(islamics::add);
        return islamics;
    }

    @DeleteMapping("/islamic/{id}")
    public ResponseEntity<String> deleteIslamic(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Islamic has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/islamic/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedIslamic(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/islamic/fields")
    public String[] getFields(){
        return Arrays.stream(Islamic.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
