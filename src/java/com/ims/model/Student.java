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
public class Student {
    private int id;
    private String name;
    private String address;
    private String gender;
    private String hobbies;
    private long phone;
    private String country;
    private String email;
    private LocalDate dob;

    public Student() {
    }

    public Student(String name, String address, String gender, String hobbies, long phone, String country, String email, LocalDate dob) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.hobbies = hobbies;
        this.phone = phone;
        this.country = country;
        this.email = email;
        this.dob = dob;
    }

    public Student(int id, String name, String address, String gender, String hobbies, long phone, String country, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.hobbies = hobbies;
        this.phone = phone;
        this.country = country;
        this.email = email;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    
   
    
}
