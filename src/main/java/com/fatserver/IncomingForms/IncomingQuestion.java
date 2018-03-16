package com.fatserver.IncomingForms;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fatserver.entity.Skill;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class IncomingQuestion {
    private Long id;
    private String title;
    private String discription;
    private Integer price;
    private Timestamp dateTime;
    private Set<IncomingSkill> skills;


    public IncomingQuestion(){
        this.id = null;
        this.title = "Title";
        this.dateTime = getDateTime();
    }

    public IncomingQuestion(String title, String discription, Set<IncomingSkill> skills, Integer price) {
        this.title = title;
        this.discription = discription;
        this.skills = skills;
        this.price = price;
    }

    public IncomingQuestion(String title, String discription) {
        this.title = title;
        this.discription = discription;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }



    public Set<IncomingSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<IncomingSkill> skills) {
        this.skills = skills;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

}
