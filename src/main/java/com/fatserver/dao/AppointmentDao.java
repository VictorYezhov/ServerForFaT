package com.fatserver.dao;

import com.fatserver.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 15.05.2018.
 */
public interface AppointmentDao extends JpaRepository<Appointment, Long> {


}
