package com.example.WebFluxPerson.api;

import com.example.WebFluxPerson.models.Person;
import com.example.WebFluxPerson.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(name = "/")
    public Flux<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping(value = "/{id}")
    public Mono<Person> getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @PostMapping(name = "/")
    public Mono<Person> addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @PutMapping(name = "/{id}")
    public Mono<Person> editPerson(@RequestBody Person body, @PathVariable Long id){
        Mono<Person> person = personService.getPersonById(id);
        person.block().setName(body.getName());
        person.block().setAge(body.getAge());
        person.block().setHobby(body.getHobby());
        return person;
    }

    @DeleteMapping(name = "/")
    public Mono<Person> DeletePerson(Long id){
        return personService.DeletePerson(id);
    }


}
