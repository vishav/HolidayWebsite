package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.Regions;
import com.xiaoxiao.calender.springholidayserver.repository.RegionsRepository;
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
public class RegionsController {
    @Autowired
    RegionsRepository repository;

    /**
     * @return all regionss object exist in the database
     */
    @GetMapping("/regions")
    public List<Regions> getAllRegions(){
        List<Regions> regionss = new ArrayList<>();
        repository.findAll().forEach(regionss::add);

        return regionss;
    }

    @RequestMapping(value = "/regions/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<Regions> create(@RequestBody Regions regionss) {
        Regions _regionss = regionss;
        _regionss.setName(regionss.getName());
        _regionss.setWorld(regionss.getWorld());
        repository.save(_regionss);
        List<Regions> regionsss = new ArrayList<>();
        repository.findAll().forEach(regionsss::add);

        return regionsss;
        // return service.create(resource);
    }


    @PutMapping("/regions/update/{id}")
    public ResponseEntity<Regions> updateRegions(@PathVariable("id") long id, @RequestBody Regions regionss) {
        System.out.println("Update Regions with ID = " + id + "...");

        Optional<Regions> regionssData = repository.findById(id);
        if (regionssData.isPresent()) {
            Regions _regionss = regionssData.get();
            _regionss.setName(regionss.getName());
            _regionss.setWorld(regionss.getWorld());


            return new ResponseEntity<>(repository.save(_regionss), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/regions/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Regions> getSearch(@RequestBody Regions regions){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<Regions> example = Example.of(regions, matcher);

        List<Regions> regionss = new ArrayList<>();
        repository.findAll(example).forEach(regionss::add);
        return regionss;
    }

    @DeleteMapping("/regions/{id}")
    public ResponseEntity<String> deleteRegions(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Regions has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/regions/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedRegions(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/regions/fields")
    public String[] getFields(){
        return Arrays.stream(Regions.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
