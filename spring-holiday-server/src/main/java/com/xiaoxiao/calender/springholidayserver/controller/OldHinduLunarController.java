package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.OldHinduLunar;
import com.xiaoxiao.calender.springholidayserver.repository.OldHinduLunarRepository;
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
public class OldHinduLunarController {
    @Autowired
    OldHinduLunarRepository repository;

    /**
     * @return all oldhindulunars object exist in the database
     */
    @GetMapping("/oldhindulunar")
    public List<OldHinduLunar> getAllOldHinduLunar(){
        List<OldHinduLunar> oldhindulunars = new ArrayList<>();
        repository.findAll().forEach(oldhindulunars::add);
        return oldhindulunars;
    }

    @RequestMapping(value = "/oldhindulunar/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<OldHinduLunar> create(@RequestBody OldHinduLunar oldhindulunars) {
        OldHinduLunar _oldhindulunars = oldhindulunars;
        _oldhindulunars.setDay(oldhindulunars.getDay());
        _oldhindulunars.setLeapmonth(oldhindulunars.getLeapmonth());
        _oldhindulunars.setMonth(oldhindulunars.getMonth());
        _oldhindulunars.setOffset(oldhindulunars.getOffset());
        repository.save(_oldhindulunars);
        List<OldHinduLunar> oldhindulunarss = new ArrayList<>();
        repository.findAll().forEach(oldhindulunarss::add);

        return oldhindulunarss;
        // return service.create(resource);
    }


    @PutMapping("/oldhindulunar/update/{id}")
    public ResponseEntity<OldHinduLunar> updateOldHinduLunar(@PathVariable("id") long id, @RequestBody OldHinduLunar oldhindulunars) {
        System.out.println("Update OldHinduLunar with ID = " + id + "...");

        Optional<OldHinduLunar> oldhindulunarsData = repository.findById(id);
        if (oldhindulunarsData.isPresent()) {
            OldHinduLunar _oldhindulunars = oldhindulunarsData.get();
            _oldhindulunars.setDay(oldhindulunars.getDay());
            _oldhindulunars.setLeapmonth(oldhindulunars.getLeapmonth());
            _oldhindulunars.setMonth(oldhindulunars.getMonth());
            _oldhindulunars.setOffset(oldhindulunars.getOffset());


            return new ResponseEntity<>(repository.save(_oldhindulunars), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/oldhindulunar/search", method = RequestMethod.POST)
    @ResponseBody
    public List<OldHinduLunar> getSearch(@RequestBody OldHinduLunar oldhindulunar){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<OldHinduLunar> example = Example.of(oldhindulunar, matcher);

        List<OldHinduLunar> oldhindulunars = new ArrayList<>();
        repository.findAll(example).forEach(oldhindulunars::add);
        return oldhindulunars;
    }

    @DeleteMapping("/oldhindulunar/{id}")
    public ResponseEntity<String> deleteOldHinduLunar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("OldHinduLunar has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/oldhindulunar/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedOldHinduLunar(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/oldhindulunar/fields")
    public String[] getFields(){
        return Arrays.stream(OldHinduLunar.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}