package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.ConcernsQuestions;
import com.xiaoxiao.calender.springholidayserver.model.FormulaNotes;
import com.xiaoxiao.calender.springholidayserver.repository.FormulaNotesRepository;
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
public class FormulaNotesController {
    @Autowired
    FormulaNotesRepository repository;

    /**
     * @return all formulaNotes object exist in the database
     */
    @GetMapping("/formulanotes")
    public List<FormulaNotes> getAllFormulaNotes(){
        List<FormulaNotes> formulaNoteses = new ArrayList<>();
        repository.findAll().forEach(formulaNoteses::add);

        return formulaNoteses;
    }


    @RequestMapping(value ="/formulanotes/search", method = RequestMethod.POST)
    @ResponseBody
    public List<FormulaNotes> getSearch(@RequestBody FormulaNotes formulaNotes){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<FormulaNotes> example = Example.of(formulaNotes, matcher);

        List<FormulaNotes> formulaNoteses = new ArrayList<>();
        repository.findAll(example).forEach(formulaNoteses::add);
        return formulaNoteses;
    }



    @RequestMapping(value = "/formulanotes/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<FormulaNotes> create(@RequestBody FormulaNotes formulaNotes) {
        FormulaNotes _formulaNotes = formulaNotes;
        _formulaNotes.setFormula_note(formulaNotes.getFormula_note());
        repository.save(_formulaNotes);
        List<FormulaNotes> formulaNotess = new ArrayList<>();
        repository.findAll().forEach(formulaNotess::add);

        return formulaNotess;
        // return service.create(resource);
    }


    @PutMapping("/formulanotes/update/{id}")
    public ResponseEntity<FormulaNotes> updateFormulaNotes(@PathVariable("id") long id, @RequestBody FormulaNotes formulaNotes) {
        System.out.println("Update FormulaNotes with ID = " + id + "...");

        Optional<FormulaNotes> formulaNotesData = repository.findById(id);
        if (formulaNotesData.isPresent()) {
            FormulaNotes _formulaNotes = formulaNotesData.get();
            _formulaNotes.setFormula_note(formulaNotes.getFormula_note());

            return new ResponseEntity<>(repository.save(_formulaNotes), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/formulanotes/{id}")
    public ResponseEntity<String> deleteFormulaNotes(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("FormulaNotes has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/formulanotes/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedFormulaNotes(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/formulanotes/fields")
    public String[] getFields(){
        return Arrays.stream(FormulaNotes.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
