package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.OldHinduLunarSpecial;
import com.xiaoxiao.calender.springholidayserver.repository.OldHinduLunarSpecialRepository;
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
public class OldHinduLunarSpecialController {
    @Autowired
    OldHinduLunarSpecialRepository repository;

    /**
     * @return all oldhinduLunarSpecials object exist in the database
     */
    @GetMapping("/oldhindulunarspecial")
    public List<OldHinduLunarSpecial> getAllOldHinduLunarSpecial(){
        List<OldHinduLunarSpecial> oldhinduLunarSpecials = new ArrayList<>();
        repository.findAll().forEach(oldhinduLunarSpecials::add);

        return oldhinduLunarSpecials;
    }

    @RequestMapping(value = "/oldhindulunarspecial/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<OldHinduLunarSpecial> create(@RequestBody OldHinduLunarSpecial oldhinduLunarSpecials) {
        OldHinduLunarSpecial _oldhinduLunarSpecials = oldhinduLunarSpecials;
        _oldhinduLunarSpecials.setDay(oldhinduLunarSpecials.getDay());
        _oldhinduLunarSpecials.setLeapmonth(oldhinduLunarSpecials.getLeapmonth());
        repository.save(_oldhinduLunarSpecials);
        List<OldHinduLunarSpecial> oldhinduLunarSpecialss = new ArrayList<>();
        repository.findAll().forEach(oldhinduLunarSpecialss::add);

        return oldhinduLunarSpecialss;
        // return service.create(resource);
    }


    @PutMapping("/oldhindulunarspecial/update/{id}")
    public ResponseEntity<OldHinduLunarSpecial> updateOldHinduLunarSpecial(@PathVariable("id") long id, @RequestBody OldHinduLunarSpecial oldhinduLunarSpecials) {
        System.out.println("Update OldHinduLunarSpecial with ID = " + id + "...");

        Optional<OldHinduLunarSpecial> oldhinduLunarSpecialsData = repository.findById(id);
        if (oldhinduLunarSpecialsData.isPresent()) {
            OldHinduLunarSpecial _oldhinduLunarSpecials = oldhinduLunarSpecialsData.get();
            _oldhinduLunarSpecials.setDay(oldhinduLunarSpecials.getDay());
            _oldhinduLunarSpecials.setMonth(oldhinduLunarSpecials.getMonth());
            _oldhinduLunarSpecials.setDescription(oldhinduLunarSpecials.getDescription());
            _oldhinduLunarSpecials.setOffset(oldhinduLunarSpecials.getOffset());
            _oldhinduLunarSpecials.setLeapmonth(oldhinduLunarSpecials.getLeapmonth());


            return new ResponseEntity<>(repository.save(_oldhinduLunarSpecials), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/oldhindulunarspecial/search", method = RequestMethod.POST)
    @ResponseBody
    public List<OldHinduLunarSpecial> getSearch(@RequestBody OldHinduLunarSpecial oldhinduLunarSpecial){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<OldHinduLunarSpecial> example = Example.of(oldhinduLunarSpecial, matcher);

        List<OldHinduLunarSpecial> oldhinduLunarSpecials = new ArrayList<>();
        repository.findAll(example).forEach(oldhinduLunarSpecials::add);
        return oldhinduLunarSpecials;
    }

    @DeleteMapping("/oldhindulunarspecial/{id}")
    public ResponseEntity<String> deleteOldHinduLunarSpecial(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("OldHinduLunarSpecial has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/oldhindulunarspecial/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedOldHinduLunarSpecial(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/oldhindulunarspecial/fields")
    public String[] getFields(){
        return Arrays.stream(OldHinduLunarSpecial.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
