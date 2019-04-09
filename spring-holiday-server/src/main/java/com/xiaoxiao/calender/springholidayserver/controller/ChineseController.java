package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.Chinese;
import com.xiaoxiao.calender.springholidayserver.repository.ChineseRepository;
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
public class ChineseController {
    @Autowired
    ChineseRepository repository;

    /**
     * @return all chineses object exist in the database
     */
    @GetMapping("/chinese")
    public List<Chinese> getAllChinese(){
        List<Chinese> chineses = new ArrayList<>();
        repository.findAll().forEach(chineses::add);
        return chineses;
    }

    @RequestMapping(value = "/chinese/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Chinese> create(@RequestBody Chinese chineses) {
        Chinese _chineses = chineses;
        _chineses.setDay(chineses.getDay());
        _chineses.setLeapmonth(chineses.getLeapmonth());
        _chineses.setMonth(chineses.getMonth());
        _chineses.setOffset(chineses.getOffset());
        repository.save(_chineses);
        List<Chinese> chinesess = new ArrayList<>();
        repository.findAll().forEach(chinesess::add);

        return chinesess;
        // return service.create(resource);
    }


    @PutMapping("/chinese/update/{id}")
    public ResponseEntity<Chinese> updateChinese(@PathVariable("id") long id, @RequestBody Chinese chineses) {
        System.out.println("Update Chinese with ID = " + id + "...");

        Optional<Chinese> chinesesData = repository.findById(id);
        if (chinesesData.isPresent()) {
            Chinese _chineses = chinesesData.get();
            _chineses.setDay(chineses.getDay());
            _chineses.setLeapmonth(chineses.getLeapmonth());
            _chineses.setMonth(chineses.getMonth());
            _chineses.setOffset(chineses.getOffset());


            return new ResponseEntity<>(repository.save(_chineses), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/chinese/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Chinese> getSearch(@RequestBody Chinese chinese){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<Chinese> example = Example.of(chinese, matcher);

        List<Chinese> chineses = new ArrayList<>();
        repository.findAll(example).forEach(chineses::add);
        return chineses;
    }

    @DeleteMapping("/chinese/{id}")
    public ResponseEntity<String> deleteChinese(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Chinese has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/chinese/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedChinese(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/chinese/fields")
    public String[] getFields(){
        return Arrays.stream(Chinese.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}