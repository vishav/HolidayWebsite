package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.OldHinduLunarMoonphase;
import com.xiaoxiao.calender.springholidayserver.repository.OldHinduLunarMoonphaseRepository;
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
public class OldHinduLunarMoonphaseController {
    @Autowired
    OldHinduLunarMoonphaseRepository repository;

    /**
     * @return all oldhinduLunarMoonphases object exist in the database
     */
    @GetMapping("/oldhindulunarmoonphase")
    public List<OldHinduLunarMoonphase> getAllOldHinduLunarMoonphase(){
        List<OldHinduLunarMoonphase> oldhinduLunarMoonphases = new ArrayList<>();
        repository.findAll().forEach(oldhinduLunarMoonphases::add);

        return oldhinduLunarMoonphases;
    }

    @RequestMapping(value = "/oldhindulunarmoonphase/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<OldHinduLunarMoonphase> create(@RequestBody OldHinduLunarMoonphase oldhinduLunarMoonphases) {
        OldHinduLunarMoonphase _oldhinduLunarMoonphases = oldhinduLunarMoonphases;
        _oldhinduLunarMoonphases.setDay(oldhinduLunarMoonphases.getDay());
        _oldhinduLunarMoonphases.setLeapmonth(oldhinduLunarMoonphases.getLeapmonth());
        repository.save(_oldhinduLunarMoonphases);
        List<OldHinduLunarMoonphase> oldhinduLunarMoonphasess = new ArrayList<>();
        repository.findAll().forEach(oldhinduLunarMoonphasess::add);

        return oldhinduLunarMoonphasess;
        // return service.create(resource);
    }


    @PutMapping("/oldhindulunarmoonphase/update/{id}")
    public ResponseEntity<OldHinduLunarMoonphase> updateOldHinduLunarMoonphase(@PathVariable("id") long id, @RequestBody OldHinduLunarMoonphase oldhinduLunarMoonphases) {
        System.out.println("Update OldHinduLunarMoonphase with ID = " + id + "...");

        Optional<OldHinduLunarMoonphase> oldhinduLunarMoonphasesData = repository.findById(id);
        if (oldhinduLunarMoonphasesData.isPresent()) {
            OldHinduLunarMoonphase _oldhinduLunarMoonphases = oldhinduLunarMoonphasesData.get();
            _oldhinduLunarMoonphases.setDay(oldhinduLunarMoonphases.getDay());
            _oldhinduLunarMoonphases.setLocation(oldhinduLunarMoonphases.getLocation());
            _oldhinduLunarMoonphases.setMonth(oldhinduLunarMoonphases.getMonth());
            _oldhinduLunarMoonphases.setMoonphase(oldhinduLunarMoonphases.getMoonphase());
            _oldhinduLunarMoonphases.setOffset(oldhinduLunarMoonphases.getOffset());
            _oldhinduLunarMoonphases.setLeapmonth(oldhinduLunarMoonphases.getLeapmonth());


            return new ResponseEntity<>(repository.save(_oldhinduLunarMoonphases), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/oldhindulunarmoonphase/search", method = RequestMethod.POST)
    @ResponseBody
    public List<OldHinduLunarMoonphase> getSearch(@RequestBody OldHinduLunarMoonphase oldhinduLunarMoonphase){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<OldHinduLunarMoonphase> example = Example.of(oldhinduLunarMoonphase, matcher);

        List<OldHinduLunarMoonphase> oldhinduLunarMoonphases = new ArrayList<>();
        repository.findAll(example).forEach(oldhinduLunarMoonphases::add);
        return oldhinduLunarMoonphases;
    }

    @DeleteMapping("/oldhindulunarmoonphase/{id}")
    public ResponseEntity<String> deleteOldHinduLunarMoonphase(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("OldHinduLunarMoonphase has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/oldhindulunarmoonphase/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedOldHinduLunarMoonphase(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/oldhindulunarmoonphase/fields")
    public String[] getFields(){
        return Arrays.stream(OldHinduLunarMoonphase.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
