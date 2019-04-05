package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.HolidayNotes;
import com.xiaoxiao.calender.springholidayserver.repository.HolidayNotesRepository;
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
public class HolidayNotesController {
    @Autowired
    HolidayNotesRepository repository;
    
    /**
     * @return all holidayNotes object exist in the database
     */
    @GetMapping("/holidaynotes")
        public List<HolidayNotes> getAllHolidayNotes(){
        List<HolidayNotes> holidayNoteses = new ArrayList<>();
        repository.findAll().forEach(holidayNoteses::add);
    
        return holidayNoteses;
    }

    @RequestMapping(value = "/holidaynotes/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<HolidayNotes> create(@RequestBody HolidayNotes holidayNotes) {
        HolidayNotes _holidayNotes = holidayNotes;
        _holidayNotes.setHoliday_note(holidayNotes.getHoliday_note());
        repository.save(_holidayNotes);
        List<HolidayNotes> holidayNotess = new ArrayList<>();
        repository.findAll().forEach(holidayNotess::add);

        return holidayNotess;
        // return service.create(resource);
    }


    @PutMapping("/holidaynotes/update/{id}")
    public ResponseEntity<HolidayNotes> updateHolidayNotes(@PathVariable("id") long id, @RequestBody HolidayNotes holidayNotes) {
        System.out.println("Update HolidayNotes with ID = " + id + "...");

        Optional<HolidayNotes> holidayNotesData = repository.findById(id);
        if (holidayNotesData.isPresent()) {
            HolidayNotes _holidayNotes = holidayNotesData.get();
            _holidayNotes.setHoliday_note(holidayNotes.getHoliday_note());
          
            return new ResponseEntity<>(repository.save(_holidayNotes), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/holidaynotes/search", method = RequestMethod.POST)
    @ResponseBody
    public List<HolidayNotes> getSearch(@RequestBody HolidayNotes holidayNotes){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<HolidayNotes> example = Example.of(holidayNotes, matcher);

        List<HolidayNotes> holidayNoteses = new ArrayList<>();
        repository.findAll(example).forEach(holidayNoteses::add);
        return holidayNoteses;
    }

    @DeleteMapping("/holidaynotes/{id}")
    public ResponseEntity<String> deleteHolidayNotes(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("HolidayNotes has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/holidaynotes/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedHolidayNotes(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/holidaynotes/fields")
    public String[] getFields(){
        return Arrays.stream(HolidayNotes.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
