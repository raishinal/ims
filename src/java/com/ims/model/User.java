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
public class User {
    // user model class
    private int id;
    private String fname;
    private String uname;
    private String upass;
    private String authority;
    private String active;
    private String gender;
    private String image;

    public User() {
    }

    public User(int id, String fname, String uname, String upass, String authority, String active, String gender, String image) {
        this.id = id;
        this.fname = fname;
        this.uname = uname;
        this.upass = upass;
        this.authority = authority;
        this.active = active;
        this.gender = gender;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
