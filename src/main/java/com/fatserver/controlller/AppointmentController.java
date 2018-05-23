package com.fatserver.controlller;

import com.fatserver.dto.AppointmentDTO;
import com.fatserver.dto.IdForAppointmentDTO;
import com.fatserver.dto.QuestionTopicAndPriceDTO;
import com.fatserver.entity.Appointment;
import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import com.fatserver.service.AppointmentService;
import com.fatserver.service.NotificationSender;
import com.fatserver.service.QuestionService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getAllUserAppointments{id}")
    public List<AppointmentDTO> sendToClientAllUsersAppointments(@PathVariable Long id){
        User me = userService.findOne(id);
        List<Appointment> appointments = appointmentService.findAppointmentsByEmployeeOrEmployer(me);
        List<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        for (Appointment app:appointments) {
            AppointmentDTO appNew = new AppointmentDTO(app);
            appointmentDTOS.add(appNew);
        }

        return appointmentDTOS;
    }

    @PostMapping("/updateAppointment")
    public String updateAppointment(@RequestBody AppointmentDTO appointmentDTO){

        Appointment appointment = appointmentService.findOne(appointmentDTO.getId());


        appointment.setTimeFor(appointmentDTO.getTimeFor());
        appointment.setAcceeptedByEmployer(appointmentDTO.isAcceeptedByEmployer());
        appointment.setAcceptedByEmployee(appointmentDTO.isAcceptedByEmployee());
        appointment.setSuccessForEmployer(appointmentDTO.isSuccessForEmployer());
        appointment.setAcceptedByEmployee(appointmentDTO.isAcceptedByEmployee());
        appointmentService.update(appointment);


        return "OK";
    }

    @GetMapping("/getTopicAndPriceOfQuestion{id}")
    public QuestionTopicAndPriceDTO sendTopicAndPriceOfQuestion(@PathVariable Long id){
        Question q = questionService.findOne(id);
        return new QuestionTopicAndPriceDTO(q.getTitle(), q.getPrice());
    }

    @GetMapping("/getNameOfYourPartner{id}")
    public String sendNameOfUserPartner(@PathVariable Long id){
        User u = userService.findOne(id);
        return u.getFamilyName() +"@"+ u.getName();
    }

    @PostMapping(value = "/changeAcceptingOnServerSide")
    public String changeAccepting(@RequestParam("contract_id") Long contract_id,
                                  @RequestParam("person_id") Long person_id,
                                  @RequestParam("accepting") boolean accepting,
                                  @RequestParam("another_person_id") Long another_person_id){

        Appointment appointment = appointmentService.findOne(contract_id);

        if(appointment.getEmployee().getId().equals(person_id)){
            appointment.setAcceptedByEmployee(accepting);
        }else if(appointment.getEmployer().getId().equals(person_id)) {
            appointment.setAcceeptedByEmployer(accepting);
        }

        appointmentService.update(appointment);
        notificationSender.sendNotificationAboutNewContract(appointment,userService.findOne(another_person_id));

        return "OK";
    }

}
