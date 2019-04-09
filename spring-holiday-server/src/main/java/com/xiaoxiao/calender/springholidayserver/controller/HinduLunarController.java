package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.HinduLunar;
import com.xiaoxiao.calender.springholidayserver.repository.HinduLunarRepository;
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
public class HinduLunarController {
    @Autowired
    HinduLunarRepository repository;

    /**
     * @return all hindulunars object exist in the database
     */
    @GetMapping("/hindulunar")
    public List<HinduLunar> getAllHinduLunar(){
        List<HinduLunar> hindulunars = new ArrayList<>();
        repository.findAll().forEach(hindulunars::add);
        return hindulunars;
    }

    @RequestMapping(value = "/hindulunar/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<HinduLunar> create(@RequestBody HinduLunar hindulunars) {
        HinduLunar _hindulunars = hindulunars;
        _hindulunars.setDay(hindulunars.getDay());
        _hindulunars.setLeapmonth(hindulunars.getLeapmonth());
        _hindulunars.setLeapday(hindulunars.getLeapday());
        _hindulunars.setMonth(hindulunars.getMonth());
        _hindulunars.setOffset(hindulunars.getOffset());
        repository.save(_hindulunars);
        List<HinduLunar> hindulunarss = new ArrayList<>();
        repository.findAll().forEach(hindulunarss::add);

        return hindulunarss;
        // return service.create(resource);
    }


    @PutMapping("/hindulunar/update/{id}")
    public ResponseEntity<HinduLunar> updateHinduLunar(@PathVariable("id") long id, @RequestBody HinduLunar hindulunars) {
        System.out.println("Update HinduLunar with ID = " + id + "...");

        Optional<HinduLunar> hindulunarsData = repository.findById(id);
        if (hindulunarsData.isPresent()) {
            HinduLunar _hindulunars = hindulunarsData.get();
            _hindulunars.setDay(hindulunars.getDay());
            _hindulunars.setLeapmonth(hindulunars.getLeapmonth());
            _hindulunars.setLeapday(hindulunars.getLeapday());
            _hindulunars.setMonth(hindulunars.getMonth());
            _hindulunars.setOffset(hindulunars.getOffset());


            return new ResponseEntity<>(repository.save(_hindulunars), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/hindulunar/search", method = RequestMethod.POST)
    @ResponseBody
    public List<HinduLunar> getSearch(@RequestBody HinduLunar hindulunar){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<HinduLunar> example = Example.of(hindulunar, matcher);

        List<HinduLunar> hindulunars = new ArrayList<>();
        repository.findAll(example).forEach(hindulunars::add);
        return hindulunars;
    }

    @DeleteMapping("/hindulunar/{id}")
    public ResponseEntity<String> deleteHinduLunar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("HinduLunar has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/hindulunar/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHinduLunar(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/hindulunar/fields")
    public String[] getFields(){
        return Arrays.stream(HinduLunar.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}