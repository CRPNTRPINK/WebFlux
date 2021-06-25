package com.example.WebFluxPerson.controllers;

import com.example.WebFluxPerson.models.Person;
import com.example.WebFluxPerson.services.PersonService;
import com.example.interfaces.controllers.PersonControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonRestController implements PersonControllerInterface<Person> {

    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(name = "/")
    public Flux<Person> getAllPersons() {
        Flux<Person> persons = personService.getAllPersons();
        return persons;
    }

    @GetMapping(value = "/{id}")
    public Mono<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping(name = "/")
    public Mono<Person> addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping(value = "/")
    public Mono<Person> editPerson(@RequestBody Person body) {
        return personService.addPerson(body);
    }

    @DeleteMapping(name = "/")
    public Mono<Person> DeletePerson(Long id) {
        return personService.DeletePerson(id);
    }


}
