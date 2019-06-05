/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.model;

import java.time.LocalDate;

/**
 *
 * @author Raishin
 */
public class Event {
    private int id;
    private String title;
    private LocalDate date;
    private String description;

    public Event() {
    }

    public Event(int id, String title, LocalDate date, String descrpition) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = descrpition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescirption() {
        return description;
    }

    public void setDescrpition(String descrpition) {
        this.description = descrpition;
    }
    
    
}
