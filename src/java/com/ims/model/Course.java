/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.model;

/**
 *
 * @author Raishin
 */
public class Course {
    
    private int id;
    private String title;
    private String duration;
    private double price;
    private String detail;

    public Course() {
    }

    public Course(String title, String duration, double price,String detail) {
        this.title = title;
        this.duration = duration;
        this.price = price;
        this.detail=detail;
    }

    public Course(int id, String title, String duration, double price,String detail) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.price = price;
        this.detail=detail;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    
}
