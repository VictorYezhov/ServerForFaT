package com.fatserver.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "job_user",
            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"))
    @JsonBackReference
    private Set<User> userListJob;


    public Job() {
        userListJob = new HashSet<>();
    }

    public Job(String name) {
        this.name = name;
    }

    public Job(String name, Set<User> userListJob) {
        this.name = name;
        this.userListJob = userListJob;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserListJob() {
        return userListJob;
    }

    public void setUserListJob(Set<User> userListJob) {
        this.userListJob = userListJob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
