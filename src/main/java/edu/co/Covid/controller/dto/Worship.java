package edu.co.Covid.controller.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "worships")
public class Worship {
    private String id;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

}