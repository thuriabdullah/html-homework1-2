package com.example.demo.Gallery;

import com.example.demo.Servies.Servies;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name="Galleries")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long galleryID;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> pictures;
    private String name;
    private String Description;
    @JsonIgnore
    @OneToOne(mappedBy = "gallery")
    private Servies servies;

    public Gallery(){}

    public Gallery(Long galleryID, List<String> pictures, String name, String description, Servies servies) {
        this.galleryID = galleryID;
        this.pictures = pictures;
        this.name = name;
        Description = description;
        this.servies = servies;
    }

    public Long getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(Long galleryID) {
        this.galleryID = galleryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public Servies getServies() {
        return servies;
    }

    public void setServies(Servies servies) {
        this.servies = servies;
    }

}
