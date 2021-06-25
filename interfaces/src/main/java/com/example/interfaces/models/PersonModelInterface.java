package com.example.interfaces.models;

public interface PersonModelInterface {
    Long id = null;
    String name = null;
    String age = null;
    String hobby = null;

    public Long getId();

    public String getName();

    public String getAge();

    public String getHobby();

    public void setId(Long id);

    public void setName(String name);

    public void setAge(String age);

    public void setHobby(String hobby);


}
