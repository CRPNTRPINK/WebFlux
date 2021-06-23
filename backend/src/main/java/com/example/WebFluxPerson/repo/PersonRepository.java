package com.example.WebFluxPerson.repo;

import com.example.WebFluxPerson.models.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
}
