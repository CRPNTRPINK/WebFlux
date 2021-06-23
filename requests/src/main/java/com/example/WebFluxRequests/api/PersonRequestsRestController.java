package com.example.WebFluxRequests.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonRequestsRestController {
    @GetMapping(value = "/")
    public Flux<String> getPersonRequest() {
        return null;
    }

    @PostMapping(value = "/")
    public Flux<String> postPersonRequest() {
        return null;
    }

    @PutMapping(value = "/")
    public Flux<String> putPersonRequest() {
        return null;
    }

    @DeleteMapping(value = "/")
    public Flux<String> deletePersonRequest() {
        return null;
    }
}
