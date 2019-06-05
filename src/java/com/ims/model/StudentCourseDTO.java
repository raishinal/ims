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
public class StudentCourseDTO {
    private int sn;
    private String name;
    private long phone;
    private String email;
    private String title;
    private String duration;
    private double price;

    public StudentCourseDTO() {
    }

    public StudentCourseDTO(int sn, String name, long phone, String email, String title, String duration, double price) {
        this.sn = sn;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.title = title;
        this.duration = duration;
        this.price = price;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    
    
}
