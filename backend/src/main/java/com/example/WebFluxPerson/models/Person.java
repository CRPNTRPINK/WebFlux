package com.example.WebFluxPerson.models;

import com.example.interfaces.models.PersonModelInterface;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Person implements PersonModelInterface {
    @Id
    private Long id;
    private String name;
    private String age;
    private String hobby;

    public Person(String name, String age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
}
