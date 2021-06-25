package com.example.request.DTO;

import com.example.interfaces.models.PersonModelInterface;
import lombok.Data;

@Data
public class PersonDTO implements PersonModelInterface {
    Long id;
    String name;
    String age;
    String hobby;
}
