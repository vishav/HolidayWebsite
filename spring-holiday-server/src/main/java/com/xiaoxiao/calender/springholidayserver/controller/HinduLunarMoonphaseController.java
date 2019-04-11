package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.HinduLunarMoonphase;
import com.xiaoxiao.calender.springholidayserver.repository.HinduLunarMoonphaseRepository;
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
public class HinduLunarMoonphaseController {
    @Autowired
    HinduLunarMoonphaseRepository repository;

    /**
     * @return all hinduLunarMoonphases object exist in the database
     */
    @GetMapping("/hindulunarmoonphase")
    public List<HinduLunarMoonphase> getAllHinduLunarMoonphase(){
        List<HinduLunarMoonphase> hinduLunarMoonphases = new ArrayList<>();
        repository.findAll().forEach(hinduLunarMoonphases::add);

        return hinduLunarMoonphases;
    }

    @RequestMapping(value = "/hindulunarmoonphase/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<HinduLunarMoonphase> create(@RequestBody HinduLunarMoonphase hinduLunarMoonphases) {
        HinduLunarMoonphase _hinduLunarMoonphases = hinduLunarMoonphases;
        _hinduLunarMoonphases.setDay(hinduLunarMoonphases.getDay());
        _hinduLunarMoonphases.setLeapmonth(hinduLunarMoonphases.getLeapmonth());
        _hinduLunarMoonphases.setLeapday(hinduLunarMoonphases.getLeapday());
        repository.save(_hinduLunarMoonphases);
        List<HinduLunarMoonphase> hinduLunarMoonphasess = new ArrayList<>();
        repository.findAll().forEach(hinduLunarMoonphasess::add);

        return hinduLunarMoonphasess;
        // return service.create(resource);
    }


    @PutMapping("/hindulunarmoonphase/update/{id}")
    public ResponseEntity<HinduLunarMoonphase> updateHinduLunarMoonphase(@PathVariable("id") long id, @RequestBody HinduLunarMoonphase hinduLunarMoonphases) {
        System.out.println("Update HinduLunarMoonphase with ID = " + id + "...");

        Optional<HinduLunarMoonphase> hinduLunarMoonphasesData = repository.findById(id);
        if (hinduLunarMoonphasesData.isPresent()) {
            HinduLunarMoonphase _hinduLunarMoonphases = hinduLunarMoonphasesData.get();
            _hinduLunarMoonphases.setDay(hinduLunarMoonphases.getDay());
            _hinduLunarMoonphases.setLocation(hinduLunarMoonphases.getLocation());
            _hinduLunarMoonphases.setMonth(hinduLunarMoonphases.getMonth());
            _hinduLunarMoonphases.setMoonphase(hinduLunarMoonphases.getMoonphase());
            _hinduLunarMoonphases.setOffset(hinduLunarMoonphases.getOffset());
            _hinduLunarMoonphases.setLeapmonth(hinduLunarMoonphases.getLeapmonth());
            _hinduLunarMoonphases.setLeapday(hinduLunarMoonphases.getLeapday());


            return new ResponseEntity<>(repository.save(_hinduLunarMoonphases), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/hindulunarmoonphase/search", method = RequestMethod.POST)
    @ResponseBody
    public List<HinduLunarMoonphase> getSearch(@RequestBody HinduLunarMoonphase hinduLunarMoonphase){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<HinduLunarMoonphase> example = Example.of(hinduLunarMoonphase, matcher);

        List<HinduLunarMoonphase> hinduLunarMoonphases = new ArrayList<>();
        repository.findAll(example).forEach(hinduLunarMoonphases::add);
        return hinduLunarMoonphases;
    }

    @DeleteMapping("/hindulunarmoonphase/{id}")
    public ResponseEntity<String> deleteHinduLunarMoonphase(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("HinduLunarMoonphase has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/hindulunarmoonphase/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHinduLunarMoonphase(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/hindulunarmoonphase/fields")
    public String[] getFields(){
        return Arrays.stream(HinduLunarMoonphase.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
