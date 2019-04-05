package com.xiaoxiao.calender.springholidayserver.controller;

import com.xiaoxiao.calender.springholidayserver.model.State;
import com.xiaoxiao.calender.springholidayserver.repository.StateRepository;
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
public class StateController {

    @Autowired
    StateRepository repository;

    /**
     * @return all States object exist in the database
     */
    @GetMapping("/states")
    public List<State> getAllStates(){
        List<State> States = new ArrayList<>();
        repository.findAll().forEach(States::add);

        return States;
    }


    /**
     * @return all holidaysLocaleDetailss object match for search para
     */
    @RequestMapping(value ="/states/search", method = RequestMethod.POST)
    @ResponseBody
    public List<State> getSearchStates(@RequestBody State state) {
      ExampleMatcher matcher = ExampleMatcher.matching();
      Example<State> example = Example.of(state, matcher);
      List<State> states = new ArrayList<>();
      repository.findAll(example).forEach(states::add);
      return states;
    }

    @PutMapping("/states/update/{id}")
    public ResponseEntity<State> updateState(@PathVariable("id") long id, @RequestBody State state) {
        System.out.println("Update Country with ID = " + id + "...");

        Optional<State> stateData = repository.findById(id);

        if (stateData.isPresent()) {
            State _state = stateData.get();
            _state.setName(state.getName());
            _state.setCountry(state.getCountry());

            return new ResponseEntity<>(repository.save(_state), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/states/create", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<State> create(@RequestBody State State) {

        repository.save(new State(State.getName(), State.getCountry()));
        List<State> States = new ArrayList<>();
        repository.findAll().forEach(States::add);

        return States;
        // return service.create(resource);
    }

    @GetMapping("/states/fields")
    public String[] getFields(){
        return Arrays.stream(State.class.getDeclaredFields())
                .map(field -> field.getName())
                .toArray(String[]::new);
    }

    @DeleteMapping("/states/{id}")
    void deleteStates(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/states/delete-requests")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<String> deleteSelectedStates(@RequestBody long[] ids) {
        Arrays.stream(ids)
                .forEach(id -> repository.deleteById(id));
        return new ResponseEntity<>("records has been deleted!", HttpStatus.OK);
    }
}
