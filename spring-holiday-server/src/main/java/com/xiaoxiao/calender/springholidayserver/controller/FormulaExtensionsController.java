package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.ConcernsQuestions;
import com.xiaoxiao.calender.springholidayserver.model.FormulaExtensions;
import com.xiaoxiao.calender.springholidayserver.repository.FormulaExtensionsRepository;
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
public class FormulaExtensionsController {
    @Autowired
    FormulaExtensionsRepository repository;

    /**
     * @return all formulaExtensions object exist in the database
     */
    @GetMapping("/formulaextensions")
    public List<FormulaExtensions> getAllFormulaExtensions(){
        List<FormulaExtensions> formulaExtensionses = new ArrayList<>();
        repository.findAll().forEach(formulaExtensionses::add);

        return formulaExtensionses;
    }


    @RequestMapping(value ="/formulaextensions/search", method = RequestMethod.POST)
    @ResponseBody
    public List<FormulaExtensions> getSearch(@RequestBody FormulaExtensions formulaExtensions){
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<FormulaExtensions> example = Example.of(formulaExtensions, matcher);

        List<FormulaExtensions> formulaExtensionses = new ArrayList<>();
        repository.findAll(example).forEach(formulaExtensionses::add);
        return formulaExtensionses;
    }



    @RequestMapping(value = "/formulaextensions/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<FormulaExtensions> create(@RequestBody FormulaExtensions formulaExtensions) {
        FormulaExtensions _formulaExtensions = formulaExtensions;
        repository.save(_formulaExtensions);
        List<FormulaExtensions> formulaExtensionss = new ArrayList<>();
        repository.findAll().forEach(formulaExtensionss::add);

        return formulaExtensionss;
        // return service.create(resource);
    }


    @PutMapping("/formulaextensions/update/{id}")
    public ResponseEntity<FormulaExtensions> updateFormulaExtensions(@PathVariable("id") long id, @RequestBody FormulaExtensions formulaExtensions) {
        System.out.println("Update FormulaExtensions with ID = " + id + "...");

        Optional<FormulaExtensions> formulaExtensionsData = repository.findById(id);
        if (formulaExtensionsData.isPresent()) {
            FormulaExtensions _formulaExtensions = formulaExtensionsData.get();

            return new ResponseEntity<>(repository.save(_formulaExtensions), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/formulaextensions/{id}")
    public ResponseEntity<String> deleteFormulaExtensions(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("FormulaExtensions has been deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/formulaextensions/delete-requests")
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedFormulaExtensions(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/formulaextensions/fields")
    public String[] getFields(){
        return Arrays.stream(FormulaExtensions.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

}
