package com.fatserver.controlller;

import com.fatserver.dto.AppointmentDTO;
import com.fatserver.dto.IdForAppointmentDTO;
import com.fatserver.entity.Appointment;
import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import com.fatserver.service.AppointmentService;
import com.fatserver.service.NotificationSender;
import com.fatserver.service.QuestionService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private NotificationSender notificationSender;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

//    public AppointmentController(NotificationSender notificationSender) {
//        this.notificationSender = notificationSender;
//    }

    @GetMapping("/getAllAppointments")
    public List<AppointmentDTO> getAll(){
        List<Appointment> all = appointmentService.findAll();
        List<AppointmentDTO> toSend = new ArrayList<>();
        for(Appointment a: all){
            toSend.add(new AppointmentDTO(a));
        }
        return toSend;
    }

    @PostMapping(value = "/newAppointment")
    public String getNewAppointment(@RequestBody IdForAppointmentDTO ifa){
        System.out.println(ifa.getId_employ());
        User from = userService.findOne(ifa.getId_employer());
        User to = userService.findOne(ifa.getId_employ());

        Question question = questionService.findOne(ifa.getQuestion_id());
        if(!appointmentService.checkExistence(question, to, from)){
            Appointment appointment = new Appointment();
            appointment.setEmployer(from);
            appointment.setEmployee(to);
            appointment.setQuestion(questionService.findOne(ifa.getQuestion_id()));
            appointmentService.save(appointment);
            Appointment a = appointmentService.findAppointmentByQuestionAndPeople(question,to,from);
            notificationSender.sendNotificationAboutNewContract(a,to);
        }


        return "Ok";
    }


}
