package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.EcclesiasticalGregorian;
import com.xiaoxiao.calender.springholidayserver.repository.EcclesiasticalGregorianRepository;
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
public class EcclesiasticalGregorianController {
    @Autowired
    EcclesiasticalGregorianRepository repository;

    /**
     * @return all ecclesiasticalgregorians object exist in the database
     */
    @GetMapping("/ecclesiasticalgregorian")
    public List<EcclesiasticalGregorian> getAllEcclesiasticalGregorian(){
        List<EcclesiasticalGregorian> ecclesiasticalgregorians = new ArrayList<>();
        repository.findAll().forEach(ecclesiasticalgregorians::add);
        return ecclesiasticalgregorians;
    }

    @RequestMapping(value = "/ecclesiasticalgregorian/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<EcclesiasticalGregorian> create(@RequestBody EcclesiasticalGregorian ecclesiasticalgregorians) {
        EcclesiasticalGregorian _ecclesiasticalgregorians = ecclesiasticalgregorians;
        _ecclesiasticalgregorians.setDaysfromeaster(ecclesiasticalgregorians.getDaysfromeaster());
        repository.save(_ecclesiasticalgregorians);
        List<EcclesiasticalGregorian> ecclesiasticalgregorianss = new ArrayList<>();
        repository.findAll().forEach(ecclesiasticalgregorianss::add);

        return ecclesiasticalgregorianss;
        // return service.create(resource);
    }


    @PutMapping("/ecclesiasticalgregorian/update/{id}")
    public ResponseEntity<EcclesiasticalGregorian> updateEcclesiasticalGregorian(@PathVariable("id") long id, @RequestBody EcclesiasticalGregorian ecclesiasticalgregorians) {
        System.out.println("Update EcclesiasticalGregorian with ID = " + id + "...");

        Optional<EcclesiasticalGregorian> ecclesiasticalgregoriansData = repository.findById(id);
        if (ecclesiasticalgregoriansData.isPresent()) {
            EcclesiasticalGregorian _ecclesiasticalgregorians = ecclesiasticalgregoriansData.get();
            _ecclesiasticalgregorians.setDaysfromeaster(ecclesiasticalgregorians.getDaysfromeaster());

            return new ResponseEntity<>(repository.save(_ecclesiasticalgregorians), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/ecclesiasticalgregorian/search", method = RequestMethod.POST)
    @ResponseBody
    public List<EcclesiasticalGregorian> getSearch(@RequestBody EcclesiasticalGregorian ecclesiasticalgregorian){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<EcclesiasticalGregorian> example = Example.of(ecclesiasticalgregorian, matcher);

        List<EcclesiasticalGregorian> ecclesiasticalgregorians = new ArrayList<>();
        repository.findAll(example).forEach(ecclesiasticalgregorians::add);
        return ecclesiasticalgregorians;
    }

    @DeleteMapping("/ecclesiasticalgregorian/{id}")
    public ResponseEntity<String> deleteEcclesiasticalGregorian(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("EcclesiasticalGregorian has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/ecclesiasticalgregorian/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedEcclesiasticalGregorian(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/ecclesiasticalgregorian/fields")
    public String[] getFields(){
        return Arrays.stream(EcclesiasticalGregorian.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}