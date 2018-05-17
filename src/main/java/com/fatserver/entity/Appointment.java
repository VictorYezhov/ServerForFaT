package com.fatserver.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Victor on 15.05.2018.
 */
@Entity
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User employer;

    @ManyToOne
    private User employee;


    @ManyToOne
    private Question question;


    private Timestamp timeFor;

    private boolean acceeptedByEmployer;
    private boolean acceptedByEmployee;
    private boolean ended;
    private boolean successForEmployer;
    private boolean successForEmployee;

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getEmployer() {
        return employer;
    }

    public void setEmployer(User employer) {
        this.employer = employer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Timestamp getTimeFor() {
        return timeFor;
    }

    public void setTimeFor(Timestamp timeFor) {
        this.timeFor = timeFor;
    }

    public boolean isAcceeptedByEmployer() {
        return acceeptedByEmployer;
    }

    public void setAcceeptedByEmployer(boolean acceeptedByEmployer) {
        this.acceeptedByEmployer = acceeptedByEmployer;
    }

    public boolean isAcceptedByEmployee() {
        return acceptedByEmployee;
    }

    public void setAcceptedByEmployee(boolean acceptedByEmployee) {
        this.acceptedByEmployee = acceptedByEmployee;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public boolean isSuccessForEmployer() {
        return successForEmployer;
    }

    public void setSuccessForEmployer(boolean successForEmployer) {
        this.successForEmployer = successForEmployer;
    }

    public boolean isSuccessForEmployee() {
        return successForEmployee;
    }

    public void setSuccessForEmployee(boolean successForEmployee) {
        this.successForEmployee = successForEmployee;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
