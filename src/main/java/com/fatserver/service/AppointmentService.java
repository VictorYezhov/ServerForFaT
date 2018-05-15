package com.fatserver.service;

import com.fatserver.entity.Appointment;

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


}
