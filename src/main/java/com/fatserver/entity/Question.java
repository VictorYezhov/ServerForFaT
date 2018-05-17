package com.fatserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fatserver.dto.QuestionDTO;
import com.fatserver.helpers.JsonDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Victor on 19.02.2018.
 * Entity class which represents question of user
 */
@Entity
public class Question  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String discription;
    private Integer price;
    private Integer views;

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

    @OneToMany(mappedBy = "question_com", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> commentsList;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Appointment>  appointments;



    public Question(String title, String discription, User user, Set<Skill> skills, Integer price, Timestamp DateTime) {
        this.title = title;
        this.discription = discription;
        this.user = user;
        this.skills = skills;
        this.price = price;
        this.dateTime = DateTime;
    }

    public Question(QuestionDTO questionDTO){
        this.title = questionDTO.getTitle();
        this.discription = questionDTO.getDiscription();
        this.dateTime = questionDTO.getDateTime();
        this.price = questionDTO.getPrice();
        skills = new HashSet<>();
        commentsList = new ArrayList<>();
        this.views = questionDTO.getViews();
    }


    public Question(String title, String discription){
        this.title = title;
        this.discription = discription;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", dateTime=" + dateTime +
                ", user=" + user +
                ", skills=" + skills +
                '}';
    }
}
