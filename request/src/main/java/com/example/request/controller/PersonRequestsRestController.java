package com.example.request.controller;


import com.example.interfaces.controllers.PersonControllerInterface;
import com.example.request.DTO.PersonDTO;
import com.example.request.requests.Requests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonRequestsRestController implements PersonControllerInterface<PersonDTO>{

    @Autowired
    Requests requests;

    @GetMapping(value = "/")
    public Flux<PersonDTO> getAllPersons() throws ExecutionException, InterruptedException {
        return Flux.concat(Flux.fromIterable(requests.getRequest("/person")));
    }

    @Override
    @GetMapping(value = "/{id}")
    public Mono<?> getPersonById(@PathVariable Long id) throws ExecutionException, InterruptedException {
        List<PersonDTO> person = requests.getRequest("/person/" + id);

        return person.isEmpty() ? null : Mono.just(person.get(0));
    }

    @Override
    @PostMapping(value = "/")
    public Mono<?> addPerson(@RequestBody PersonDTO person) {
        return null;
    }

    @Override
    @PutMapping(value = "/")
    public Mono<?> editPerson(@RequestBody PersonDTO person) {
        return null;
    }

    @Override
    @DeleteMapping(value = "/")
    public Mono<?> DeletePerson(Long id) {
        return null;
    }


}
