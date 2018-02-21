package com.fatserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String job;
    private String year;

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

    public Job(String job, String year) {
        this.job = job;
        this.year = year;

    }

    public Job(String job, String year, Set<User> userList) {
        this.job = job;
        this.year = year;
        this.userListJob = userList;
    }


    public String getName() {
        return job;
    }

    public void setName(String name) {
        this.job = name;
    }

    public Set<User> getUserList() {
        return userListJob;
    }

    public void setUserList(Set<User> userList) {
        this.userListJob = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", job='" + job + '\'' +
                '}';
    }
}
