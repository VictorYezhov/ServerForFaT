package com.fatserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fatserver.IncomingForms.RegistrationForm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Victor on 11.02.2018.
 * entity class that represents user
 */
@Entity

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String familyName;
    private String email;
    private String password;
    private int rating;
    private String address;
    private String mobileNumber;
    private String pathToImage;

    private String gcmRegId;



    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonManagedReference
    private City city;




    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Skill> skills;


    @ManyToMany(mappedBy = "userListJob")
    @JsonManagedReference
    private Set<Job> jobs;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Question> questions;




    @OneToMany(mappedBy = "side1", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Contact> myContacts;

    @OneToMany(mappedBy = "side2", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Contact> MeInСontact;

    @OneToMany(mappedBy = "from", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Message> myMessages;


    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
    private List<Appointment> meAsEmployer;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Appointment> meAsEmpoyee;

    @OneToMany(mappedBy = "about", fetch = FetchType.LAZY)
    private List<Review> reviewsAboutUser;

    @OneToMany(mappedBy = "from", fetch = FetchType.LAZY)
    private List<Review> reviewsFromUser;






    public User() {
        skills = new HashSet<>();
        jobs = new HashSet<>();
        questions = new ArrayList<>();
    }

    public User(RegistrationForm user) {

        this.name = user.getName();
        this.familyName = user.getFamilyName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.rating = user.getRating();
        this.address = user.getAddress();
        this.mobileNumber = user.getMobileNumber();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<Job>  getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job>  jobs) {
        this.jobs = jobs;
    }

    public Set<Skill>  getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill>  skills) {
        this.skills = skills;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    public String getGcmRegId() {
        return gcmRegId;
    }

    public void setGcmRegId(String gcmRegId) {
        this.gcmRegId = gcmRegId;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(List<Contact> myContacts) {
        this.myContacts = myContacts;
    }

    public List<Contact> getMeIncontact() {
        return MeInСontact;
    }

    public void setMeIncontact(List<Contact> MeInСontact) {
       this.MeInСontact = MeInСontact;
    }


    public List<Contact> getMeInСontact() {
        return MeInСontact;
    }

    public void setMeInСontact(List<Contact> meInСontact) {
        MeInСontact = meInСontact;
    }

    public List<Message> getMyMessages() {
        return myMessages;
    }

    public void setMyMessages(List<Message> myMessages) {
        this.myMessages = myMessages;
    }

    public List<Appointment> getMeAsEmployer() {
        return meAsEmployer;
    }

    public void setMeAsEmployer(List<Appointment> meAsEmployer) {
        this.meAsEmployer = meAsEmployer;
    }

    public List<Appointment> getMeAsEmpoyee() {
        return meAsEmpoyee;
    }

    public void setMeAsEmpoyee(List<Appointment> meAsEmpoyee) {
        this.meAsEmpoyee = meAsEmpoyee;
    }

    public List<Review> getReviewsAboutUser() {
        return reviewsAboutUser;
    }

    public void setReviewsAboutUser(List<Review> reviewsAboutUser) {
        this.reviewsAboutUser = reviewsAboutUser;
    }
}
