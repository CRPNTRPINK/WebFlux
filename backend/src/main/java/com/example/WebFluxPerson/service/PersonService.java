package com.example.WebFluxPerson.service;

import com.example.WebFluxPerson.models.Person;
import com.example.WebFluxPerson.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Flux<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Mono<Person> getPersonById(Long id){
        return personRepository.findById(id);
    }

    public Mono<Person> addPerson(Person person){
        return personRepository.save(person);
    }

    public Mono<Person> DeletePerson(Long id) {
        Mono<Person> person = personRepository.findById(id);
        personRepository.delete(person.block());
        return person;
    }
}
