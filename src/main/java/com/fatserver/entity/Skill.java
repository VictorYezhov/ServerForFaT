package com.fatserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Victor on 16.02.2018.
 * Entity class for skills
 */
@Entity
public class Skill implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "skill_user",
            joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"))
    @JsonBackReference
    private Set<User> userList;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "skill_question",
            joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "question_id",
                    referencedColumnName = "id"))
    @JsonBackReference
    private Set<Question> questionList;


    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private Category category;



    public Skill() {
        userList = new HashSet<>();
        questionList = new HashSet<>();
    }

    public Skill(String name) {
        userList = new HashSet<>();
        questionList = new HashSet<>();
        this.name = name;
    }

    public Skill(String name, Set<User> userList) {
        this.name = name;
        this.userList = userList;
        questionList = new HashSet<>();
    }

    public Skill(String name, Set<User> userList, Set<Question> questionList) {
        this.name = name;
        this.userList = userList;
        this.questionList = questionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(Set<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
