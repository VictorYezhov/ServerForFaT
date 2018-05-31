package com.fatserver.dao;

import com.fatserver.entity.Appointment;
import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Victor on 15.05.2018.
 */
public interface AppointmentDao extends JpaRepository<Appointment, Long> {


    Appointment findAppointmentByQuestionAndEmployeeAndEmployer(Question question, User employee, User employer);

    List<Appointment> findAppointmentsByEmployeeOrEmployer(User user1, User user2);

    Integer countAllByEndedAndEmployee(Boolean ended, User employee);


}
