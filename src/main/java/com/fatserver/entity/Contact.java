package com.fatserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Victor on 06.05.2018.
 */
@Entity
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private User side1;

    @ManyToOne
    @JsonBackReference
    private User side2;

    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Message> messages;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSide1() {
        return side1;
    }

    public void setSide1(User side1) {
        this.side1 = side1;
    }

    public User getSide2() {
        return side2;
    }

    public void setSide2(User side2) {
        this.side2 = side2;
    }
}
