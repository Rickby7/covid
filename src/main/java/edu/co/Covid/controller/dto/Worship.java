package edu.co.covid.controller.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "worships")
public class Worship {
    private String id;
    private Date startDate;
    private Date endDate;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }
}