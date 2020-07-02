package edu.co.covid.controller.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "responsibles")
public class Responsible {
    @Id
    private String id;
    private Person person;
    private String position;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Person getPerson() { return person; }

    public void setPerson(Person person) { this.person = person; }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }
}