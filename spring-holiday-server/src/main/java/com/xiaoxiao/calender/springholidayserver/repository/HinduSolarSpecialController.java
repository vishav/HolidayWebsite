package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.HinduSolarSpecial;
import com.xiaoxiao.calender.springholidayserver.repository.HinduSolarSpecialRepository;
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
public class HinduSolarSpecialController {
    @Autowired
    HinduSolarSpecialRepository repository;

    /**
     * @return all hinduSolarSpecials object exist in the database
     */
    @GetMapping("/hindusolarspecial")
    public List<HinduSolarSpecial> getAllHinduSolarSpecial(){
        List<HinduSolarSpecial> hinduSolarSpecials = new ArrayList<>();
        repository.findAll().forEach(hinduSolarSpecials::add);

        return hinduSolarSpecials;
    }

    @RequestMapping(value = "/hindusolarspecial/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<HinduSolarSpecial> create(@RequestBody HinduSolarSpecial hinduSolarSpecials) {
        HinduSolarSpecial _hinduSolarSpecials = hinduSolarSpecials;
        _hinduSolarSpecials.setDay(hinduSolarSpecials.getDay());
        repository.save(_hinduSolarSpecials);
        List<HinduSolarSpecial> hinduSolarSpecialss = new ArrayList<>();
        repository.findAll().forEach(hinduSolarSpecialss::add);

        return hinduSolarSpecialss;
        // return service.create(resource);
    }


    @PutMapping("/hindusolarspecial/update/{id}")
    public ResponseEntity<HinduSolarSpecial> updateHinduSolarSpecial(@PathVariable("id") long id, @RequestBody HinduSolarSpecial hinduSolarSpecials) {
        System.out.println("Update HinduSolarSpecial with ID = " + id + "...");

        Optional<HinduSolarSpecial> hinduSolarSpecialsData = repository.findById(id);
        if (hinduSolarSpecialsData.isPresent()) {
            HinduSolarSpecial _hinduSolarSpecials = hinduSolarSpecialsData.get();
            _hinduSolarSpecials.setDay(hinduSolarSpecials.getDay());
            _hinduSolarSpecials.setMonth(hinduSolarSpecials.getMonth());
            _hinduSolarSpecials.setDescription(hinduSolarSpecials.getDescription());
            _hinduSolarSpecials.setOffset(hinduSolarSpecials.getOffset());


            return new ResponseEntity<>(repository.save(_hinduSolarSpecials), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/hindusolarspecial/search", method = RequestMethod.POST)
    @ResponseBody
    public List<HinduSolarSpecial> getSearch(@RequestBody HinduSolarSpecial hinduSolarSpecial){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<HinduSolarSpecial> example = Example.of(hinduSolarSpecial, matcher);

        List<HinduSolarSpecial> hinduSolarSpecials = new ArrayList<>();
        repository.findAll(example).forEach(hinduSolarSpecials::add);
        return hinduSolarSpecials;
    }

    @DeleteMapping("/hindusolarspecial/{id}")
    public ResponseEntity<String> deleteHinduSolarSpecial(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("HinduSolarSpecial has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/hindusolarspecial/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHinduSolarSpecial(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/hindusolarspecial/fields")
    public String[] getFields(){
        return Arrays.stream(HinduSolarSpecial.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
