package com.fatserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fatserver.helpers.JsonDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Victor on 19.02.2018.
 */
@Entity
public class Question  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String discription;

    @JsonSerialize(using = JsonDateSerializer.class)
    private Timestamp dateTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


    @ManyToMany(mappedBy = "questionList", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Skill> skills;


    public Question(String title, String discription, Category category, User user, Set<Skill> skills, Timestamp DateTime) {
        this.title = title;
        this.discription = discription;
        this.category = category;
        this.user = user;
        this.skills = skills;
        this.dateTime = DateTime;
    }

    public Question(String title, String discription, Category category) {
        this.title = title;
        this.discription = discription;
        this.category = category;
    }

    public Question() {
        skills = new HashSet<>();
        dateTime = getDateTime();
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
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
                ", category=" + category +
                ", user=" + user +
                ", skills=" + skills +
                '}';
    }
}
