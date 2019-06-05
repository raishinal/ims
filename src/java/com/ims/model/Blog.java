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
public class Blog {
    private int id;
    private String title;
    private String author;
    private String category;
    private String article;
    private LocalDate date;
    private String image;

    public Blog() {
    }

    public Blog(int id, String title, String author, String category, String article, LocalDate date , String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.article = article;
        this.date = date;
        this.image = image;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
