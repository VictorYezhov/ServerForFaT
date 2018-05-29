package com.fatserver.service;

import com.fatserver.entity.Appointment;
import com.fatserver.entity.Question;
import com.fatserver.entity.User;

import java.util.List;

/**
 * Created by Victor on 15.05.2018.
 */
public interface AppointmentService {

    void save(Appointment appointment);

    List<Appointment> findAll();

    Appointment findOne(Long id);

    void delete(Long  id);

    void update(Appointment appointment);

    boolean  checkExistence(Question question, User employee, User employer);


    Appointment findAppointmentByQuestionAndPeople(Question question, User employee, User employer);

    List<Appointment> findAppointmentsByEmployeeOrEmployer(User user);

    Integer countAllByEndedAndEmployee(Boolean ended, User employee);


}
