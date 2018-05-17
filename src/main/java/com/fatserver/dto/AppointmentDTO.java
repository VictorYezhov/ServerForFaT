package com.fatserver.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fatserver.entity.Appointment;
import com.fatserver.helpers.JsonDateSerializer;

import java.sql.Timestamp;

/**
 * Created by Victor on 15.05.2018.
 */
public class AppointmentDTO {

    private Long id;
    private Long employerId;
    private Long employeeId;
    private Long questionId;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Timestamp timeFor;
    private boolean acceeptedByEmployer;
    private boolean acceptedByEmployee;
    private boolean ended;
    private boolean successForEmployer;
    private boolean successForEmployee;

    public AppointmentDTO(Appointment appointment) {
        id = appointment.getId();
        employeeId = appointment.getEmployee().getId();
        employerId = appointment.getEmployer().getId();
        questionId = appointment.getQuestion().getId();
        timeFor = appointment.getTimeFor();
        acceeptedByEmployer = appointment.isAcceeptedByEmployer();
        acceptedByEmployee = appointment.isAcceptedByEmployee();
        ended = appointment.isEnded();
        successForEmployer = appointment.isSuccessForEmployer();
        successForEmployee = appointment.isSuccessForEmployee();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
