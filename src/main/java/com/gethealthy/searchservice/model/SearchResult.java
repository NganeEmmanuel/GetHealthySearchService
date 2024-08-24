package com.gethealthy.searchservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SearchResult {
    private String title;
    private String description;
    private String source;  //from events or sickness cycle services
    private Date dateAdded;
    private String eventType; //if result is from the event service (Symptoms, hospital visit, medication administration

    public SearchResult(String title, String description, String source, Date dateAdded) {}
}
