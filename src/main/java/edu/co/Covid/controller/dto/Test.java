package edu.co.Covid.controller.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "test")
public class Test implements Serializable {

    @Id
    private String id;
    private Date date;
    private Person person;
    private Responsible responsible;
    private boolean fever;
    private boolean cough;
    private boolean pain;
    private boolean breathe;
    private boolean secretion;
    private boolean family;
    private boolean nearby;
    private double inTemperature;
    private double outTemperature;

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getPerson() { return person; }

    public void setPerson(Person person) { this.person = person; }

    public Responsible getResponsible() { return responsible; }

    public void setResponsible(Responsible responsible) { this.responsible = responsible; }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isPain() {
        return pain;
    }

    public void setPain(boolean pain) {
        this.pain = pain;
    }

    public boolean isBreathe() {
        return breathe;
    }

    public void setBreathe(boolean breathe) {
        this.breathe = breathe;
    }

    public boolean isSecretion() {
        return secretion;
    }

    public void setSecretion(boolean secretion) {
        this.secretion = secretion;
    }

    public boolean isFamily() {
        return family;
    }

    public void setFamily(boolean family) {
        this.family = family;
    }

    public boolean isNearby() {
        return nearby;
    }

    public void setNearby(boolean nearby) {
        this.nearby = nearby;
    }

    public double getInTemperature() {
        return inTemperature;
    }

    public void setInTemperature(double inTemperature) {
        this.inTemperature = inTemperature;
    }

    public double getOutTemperature() {
        return outTemperature;
    }

    public void setOutTemperature(double outTemperature) {
        this.outTemperature = outTemperature;
    }
}
