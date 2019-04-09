package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.EcclesiasticalOrthodox;
import com.xiaoxiao.calender.springholidayserver.repository.EcclesiasticalOrthodoxRepository;
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
public class EcclesiasticalOrthodoxController {
    @Autowired
    EcclesiasticalOrthodoxRepository repository;

    /**
     * @return all ecclesiasticalorthodoxs object exist in the database
     */
    @GetMapping("/ecclesiasticalorthodox")
    public List<EcclesiasticalOrthodox> getAllEcclesiasticalOrthodox(){
        List<EcclesiasticalOrthodox> ecclesiasticalorthodoxs = new ArrayList<>();
        repository.findAll().forEach(ecclesiasticalorthodoxs::add);
        return ecclesiasticalorthodoxs;
    }

    @RequestMapping(value = "/ecclesiasticalorthodox/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<EcclesiasticalOrthodox> create(@RequestBody EcclesiasticalOrthodox ecclesiasticalorthodoxs) {
        EcclesiasticalOrthodox _ecclesiasticalorthodoxs = ecclesiasticalorthodoxs;
        _ecclesiasticalorthodoxs.setDaysfromeaster(ecclesiasticalorthodoxs.getDaysfromeaster());
        repository.save(_ecclesiasticalorthodoxs);
        List<EcclesiasticalOrthodox> ecclesiasticalorthodoxss = new ArrayList<>();
        repository.findAll().forEach(ecclesiasticalorthodoxss::add);

        return ecclesiasticalorthodoxss;
        // return service.create(resource);
    }


    @PutMapping("/ecclesiasticalorthodox/update/{id}")
    public ResponseEntity<EcclesiasticalOrthodox> updateEcclesiasticalOrthodox(@PathVariable("id") long id, @RequestBody EcclesiasticalOrthodox ecclesiasticalorthodoxs) {
        System.out.println("Update EcclesiasticalOrthodox with ID = " + id + "...");

        Optional<EcclesiasticalOrthodox> ecclesiasticalorthodoxsData = repository.findById(id);
        if (ecclesiasticalorthodoxsData.isPresent()) {
            EcclesiasticalOrthodox _ecclesiasticalorthodoxs = ecclesiasticalorthodoxsData.get();
            _ecclesiasticalorthodoxs.setDaysfromeaster(ecclesiasticalorthodoxs.getDaysfromeaster());

            return new ResponseEntity<>(repository.save(_ecclesiasticalorthodoxs), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/ecclesiasticalorthodox/search", method = RequestMethod.POST)
    @ResponseBody
    public List<EcclesiasticalOrthodox> getSearch(@RequestBody EcclesiasticalOrthodox ecclesiasticalorthodox){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<EcclesiasticalOrthodox> example = Example.of(ecclesiasticalorthodox, matcher);

        List<EcclesiasticalOrthodox> ecclesiasticalorthodoxs = new ArrayList<>();
        repository.findAll(example).forEach(ecclesiasticalorthodoxs::add);
        return ecclesiasticalorthodoxs;
    }

    @DeleteMapping("/ecclesiasticalorthodox/{id}")
    public ResponseEntity<String> deleteEcclesiasticalOrthodox(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("EcclesiasticalOrthodox has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/ecclesiasticalorthodox/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedEcclesiasticalOrthodox(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/ecclesiasticalorthodox/fields")
    public String[] getFields(){
        return Arrays.stream(EcclesiasticalOrthodox.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}