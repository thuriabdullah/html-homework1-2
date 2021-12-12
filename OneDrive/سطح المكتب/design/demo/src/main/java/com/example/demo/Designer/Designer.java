package com.example.demo.Designer;

import com.example.demo.Servies.Servies;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Designers")
public class Designer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  designerNumber;
    private String fullName;
    private String userName;
    private int password;
    private int age;
    private double  rate;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> protofolio;
    private boolean Availabilty;
    @Column
    @ElementCollection(targetClass=String.class)
    private  List<String> designType;
@JsonIgnore
@OneToMany(mappedBy = "designer")
private List<Servies> servies;
    public Designer(){}

    public Designer(Long designerNumber, String fullName, String userName, int password, int age, double rate, List<String> protofolio, boolean availabilty, List<String> designType, List<Servies> servies) {
        this.designerNumber = designerNumber;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.rate = rate;
        this.protofolio = protofolio;
        Availabilty = availabilty;
        this.designType = designType;
        this.servies = servies;
    }

    public Long getDesignerNumber() {
        return designerNumber;
    }

    public void setDesignerNumber(Long designerNumber) {
        this.designerNumber = designerNumber;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isAvailabilty() {
        return Availabilty;
    }

    public void setAvailabilty(boolean availabilty) {
        Availabilty = availabilty;
    }

    public List<Servies> getServies() {
        return servies;
    }

    public void setServies(List<Servies> servies) {
        this.servies = servies;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getProtofolio() {
        return protofolio;
    }

    public void setProtofolio(List<String> protofolio) {
        this.protofolio = protofolio;
    }

    public List<String> getDesignType() {
        return designType;
    }

    public void setDesignType(List<String> designType) {
        this.designType = designType;
    }

}
