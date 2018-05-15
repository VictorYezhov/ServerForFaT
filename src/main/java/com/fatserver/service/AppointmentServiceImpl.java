package com.fatserver.service;

import com.fatserver.dao.AppointmentDao;
import com.fatserver.entity.Appointment;
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



}
