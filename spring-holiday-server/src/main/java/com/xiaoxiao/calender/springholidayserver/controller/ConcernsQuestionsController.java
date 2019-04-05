package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.ConcernsQuestions;
import com.xiaoxiao.calender.springholidayserver.model.Country;
import com.xiaoxiao.calender.springholidayserver.repository.ConcernsQuestionsRepository;
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
public class ConcernsQuestionsController {

    @Autowired
    ConcernsQuestionsRepository repository;
    /**
     * @return all concernsQuestionss object exist in the database
     */
    @GetMapping("/concernsQuestions")
    public List<ConcernsQuestions> getAllConcernsQuestionss(){
        List<ConcernsQuestions> concernsQuestionss = new ArrayList<>();
        repository.findAll().forEach(concernsQuestionss::add);

        return concernsQuestionss;
    }



    @RequestMapping(value ="/concernsQuestions/search", method = RequestMethod.POST)
    @ResponseBody
    public List<ConcernsQuestions> getSearch(@RequestBody ConcernsQuestions object){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<ConcernsQuestions> example = Example.of(object, matcher);

        List<ConcernsQuestions> objects = new ArrayList<>();
        repository.findAll(example).forEach(objects::add);

        return objects;
    }

    @PutMapping("/concernsQuestions/update/{id}")
    public ResponseEntity<ConcernsQuestions> updateConcernsQuestions(@PathVariable("id") long id, @RequestBody ConcernsQuestions concernsQuestions) {
        System.out.println("Update ConcernsQuestions with ID = " + id + "...");

        Optional<ConcernsQuestions> concernsQuestionsData = repository.findById(id);

        if (concernsQuestionsData.isPresent()) {
            ConcernsQuestions _concernsQuestions = concernsQuestionsData.get();
            _concernsQuestions.setConcernQuestion(concernsQuestions.getConcernQuestion());

            return new ResponseEntity<>(repository.save(_concernsQuestions), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/concernsQuestions/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<ConcernsQuestions> create(@RequestBody ConcernsQuestions ConcernsQuestions) {

        repository.save(new ConcernsQuestions(ConcernsQuestions.getConcernQuestion()));
        List<ConcernsQuestions> concernsQuestionss = new ArrayList<>();
        repository.findAll().forEach(concernsQuestionss::add);

        return concernsQuestionss;
        // return service.create(resource);
    }

    @DeleteMapping("/concernsQuestions/{id}")
    public ResponseEntity<String> deleteConcernsQuestionss(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("ConcernsQuestionss has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/concernsQuestions/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedConcernsQuestions(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/concernsQuestions/fields")
    public String[] getFields(){
        return Arrays.stream(ConcernsQuestions.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}

