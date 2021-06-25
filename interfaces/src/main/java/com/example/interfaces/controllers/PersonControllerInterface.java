package com.example.interfaces.controllers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

public interface PersonControllerInterface<S> {
    Flux<?> getAllPersons() throws ExecutionException, InterruptedException;

    Mono<?> getPersonById(Long id) throws ExecutionException, InterruptedException;

    Mono<?> addPerson(S person);

    Mono<?> editPerson(S person);

    Mono<?> DeletePerson(Long id);
}
