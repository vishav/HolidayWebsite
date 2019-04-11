package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.HinduLunarSpecial;
import com.xiaoxiao.calender.springholidayserver.repository.HinduLunarSpecialRepository;
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
public class HinduLunarSpecialController {
    @Autowired
    HinduLunarSpecialRepository repository;

    /**
     * @return all hinduLunarSpecials object exist in the database
     */
    @GetMapping("/hindulunarspecial")
    public List<HinduLunarSpecial> getAllHinduLunarSpecial(){
        List<HinduLunarSpecial> hinduLunarSpecials = new ArrayList<>();
        repository.findAll().forEach(hinduLunarSpecials::add);

        return hinduLunarSpecials;
    }

    @RequestMapping(value = "/hindulunarspecial/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<HinduLunarSpecial> create(@RequestBody HinduLunarSpecial hinduLunarSpecials) {
        HinduLunarSpecial _hinduLunarSpecials = hinduLunarSpecials;
        _hinduLunarSpecials.setDay(hinduLunarSpecials.getDay());
        _hinduLunarSpecials.setLeapmonth(hinduLunarSpecials.getLeapmonth());
        _hinduLunarSpecials.setLeapday(hinduLunarSpecials.getLeapday());
        repository.save(_hinduLunarSpecials);
        List<HinduLunarSpecial> hinduLunarSpecialss = new ArrayList<>();
        repository.findAll().forEach(hinduLunarSpecialss::add);

        return hinduLunarSpecialss;
        // return service.create(resource);
    }


    @PutMapping("/hindulunarspecial/update/{id}")
    public ResponseEntity<HinduLunarSpecial> updateHinduLunarSpecial(@PathVariable("id") long id, @RequestBody HinduLunarSpecial hinduLunarSpecials) {
        System.out.println("Update HinduLunarSpecial with ID = " + id + "...");

        Optional<HinduLunarSpecial> hinduLunarSpecialsData = repository.findById(id);
        if (hinduLunarSpecialsData.isPresent()) {
            HinduLunarSpecial _hinduLunarSpecials = hinduLunarSpecialsData.get();
            _hinduLunarSpecials.setDay(hinduLunarSpecials.getDay());
            _hinduLunarSpecials.setMonth(hinduLunarSpecials.getMonth());
            _hinduLunarSpecials.setDescription(hinduLunarSpecials.getDescription());
            _hinduLunarSpecials.setOffset(hinduLunarSpecials.getOffset());
            _hinduLunarSpecials.setLeapmonth(hinduLunarSpecials.getLeapmonth());
            _hinduLunarSpecials.setLeapday(hinduLunarSpecials.getLeapday());


            return new ResponseEntity<>(repository.save(_hinduLunarSpecials), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/hindulunarspecial/search", method = RequestMethod.POST)
    @ResponseBody
    public List<HinduLunarSpecial> getSearch(@RequestBody HinduLunarSpecial hinduLunarSpecial){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<HinduLunarSpecial> example = Example.of(hinduLunarSpecial, matcher);

        List<HinduLunarSpecial> hinduLunarSpecials = new ArrayList<>();
        repository.findAll(example).forEach(hinduLunarSpecials::add);
        return hinduLunarSpecials;
    }

    @DeleteMapping("/hindulunarspecial/{id}")
    public ResponseEntity<String> deleteHinduLunarSpecial(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("HinduLunarSpecial has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/hindulunarspecial/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHinduLunarSpecial(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/hindulunarspecial/fields")
    public String[] getFields(){
        return Arrays.stream(HinduLunarSpecial.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
