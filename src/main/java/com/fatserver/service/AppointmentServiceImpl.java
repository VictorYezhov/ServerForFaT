package com.fatserver.service;

import com.fatserver.dao.AppointmentDao;
import com.fatserver.entity.Appointment;
import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 15.05.2018.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao  appointmentDao;

    @Override
    public void save(Appointment appointment) {
        appointmentDao.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    @Override
    public Appointment findOne(Long id) {
        return appointmentDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        appointmentDao.delete(id);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentDao.save(appointment);
    }

    /***
     * Return true if appointment already exists
     * @param question question for what appointment
     * @param employee employee
     * @param employer employer
     * @return
     */
    @Override
    public boolean checkExistence(Question question, User employee, User employer) {
        return appointmentDao.findAppointmentByQuestionAndEmployeeAndEmployer(question, employee,employer) != null;
    }

    @Override
    public Appointment findAppointmentByQuestionAndPeople(Question question, User employee, User employer) {
        return appointmentDao.findAppointmentByQuestionAndEmployeeAndEmployer(question, employee,employer);
    }

    @Override
    public List<Appointment> findAppointmentsByEmployeeOrEmployer(User user) {
        return appointmentDao.findAppointmentsByEmployeeOrEmployer(user, user);
    }

    @Override
    public Integer countAllByEndedAndEmployee(Boolean ended, User employee) {
        return appointmentDao.countAllByEndedAndEmployee(ended, employee);
    }


}
