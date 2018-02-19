package com.fatserver.entity;

import javax.persistence.*;

/**
 * Created by Victor on 19.02.2018.
 */
@Entity
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String Discription;

    @ManyToOne
    @JoinColumn(name = "question_category_id")
    private Category category;



    public Question(String title, String discription, Category category) {
        this.title = title;
        Discription = discription;
        this.category = category;
    }

    public Question() {
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
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
