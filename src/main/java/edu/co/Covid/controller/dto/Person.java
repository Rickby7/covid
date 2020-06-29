package edu.co.Covid.controller.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "people")
public class Person implements Serializable {
    @Id
    private String id;
    private String fullName;
    private String documentNumber;
    private Worship worship;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDocumentNumber() { return documentNumber; }

    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public Worship getWorship() { return worship; }

    public void setWorship(Worship worship) { this.worship = worship; }
}
