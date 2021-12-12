package com.example.demo.Servies;

import com.example.demo.Designer.Designer;
import com.example.demo.Gallery.Gallery;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="servicies")
public class Servies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviesID ;
    private String title;
    private String description;
    private Date duration;
    private double price;
    private String type;
@ManyToOne(fetch = FetchType.EAGER)
private Designer designer;
@OneToOne(fetch = FetchType.EAGER)
private Gallery gallery;
    public Servies(){}


    public Servies(Long serviesID, String title, String description, Date duration, double price, String type, Designer designer, Gallery gallery) {
        this.serviesID = serviesID;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.type = type;
        this.designer = designer;
        this.gallery = gallery;
    }

    public Long getServiesID() {
        return serviesID;
    }

    public void setServiesID(Long serviesID) {
        this.serviesID = serviesID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }
}
