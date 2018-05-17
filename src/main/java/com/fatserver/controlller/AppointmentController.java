package com.fatserver.controlller;

import com.fatserver.dto.AppointmentDTO;
import com.fatserver.entity.Appointment;
import com.fatserver.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 15.05.2018.
 */
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;



    @GetMapping("/getAllAppointments")
    public List<AppointmentDTO> getAll(){
        List<Appointment> all = appointmentService.findAll();
        List<AppointmentDTO> toSend = new ArrayList<>();
        for(Appointment a: all){
            toSend.add(new AppointmentDTO(a));
        }
        return toSend;
    }


}
