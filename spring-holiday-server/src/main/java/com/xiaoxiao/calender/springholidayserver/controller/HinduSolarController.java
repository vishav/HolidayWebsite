package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.HinduSolar;
import com.xiaoxiao.calender.springholidayserver.repository.HinduSolarRepository;
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
public class HinduSolarController {
    @Autowired
    HinduSolarRepository repository;

    /**
     * @return all hindusolars object exist in the database
     */
    @GetMapping("/hindusolar")
    public List<HinduSolar> getAllHinduSolar(){
        List<HinduSolar> hindusolars = new ArrayList<>();
        repository.findAll().forEach(hindusolars::add);
        return hindusolars;
    }

    @RequestMapping(value = "/hindusolar/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<HinduSolar> create(@RequestBody HinduSolar hindusolars) {
        HinduSolar _hindusolars = hindusolars;
        _hindusolars.setDay(hindusolars.getDay());
        _hindusolars.setMonth(hindusolars.getMonth());
        _hindusolars.setOffset(hindusolars.getOffset());
        repository.save(_hindusolars);
        List<HinduSolar> hindusolarss = new ArrayList<>();
        repository.findAll().forEach(hindusolarss::add);

        return hindusolarss;
        // return service.create(resource);
    }


    @PutMapping("/hindusolar/update/{id}")
    public ResponseEntity<HinduSolar> updateHinduSolar(@PathVariable("id") long id, @RequestBody HinduSolar hindusolars) {
        System.out.println("Update HinduSolar with ID = " + id + "...");

        Optional<HinduSolar> hindusolarsData = repository.findById(id);
        if (hindusolarsData.isPresent()) {
            HinduSolar _hindusolars = hindusolarsData.get();
            _hindusolars.setDay(hindusolars.getDay());
            _hindusolars.setMonth(hindusolars.getMonth());
            _hindusolars.setOffset(hindusolars.getOffset());


            return new ResponseEntity<>(repository.save(_hindusolars), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/hindusolar/search", method = RequestMethod.POST)
    @ResponseBody
    public List<HinduSolar> getSearch(@RequestBody HinduSolar hindusolar){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<HinduSolar> example = Example.of(hindusolar, matcher);

        List<HinduSolar> hindusolars = new ArrayList<>();
        repository.findAll(example).forEach(hindusolars::add);
        return hindusolars;
    }

    @DeleteMapping("/hindusolar/{id}")
    public ResponseEntity<String> deleteHinduSolar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("HinduSolar has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/hindusolar/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHinduSolar(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/hindusolar/fields")
    public String[] getFields(){
        return Arrays.stream(HinduSolar.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}