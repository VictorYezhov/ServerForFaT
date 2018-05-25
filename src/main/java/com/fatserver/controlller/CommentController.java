package com.fatserver.controlller;

import com.fatserver.dto.CommentDTO;
import com.fatserver.entity.Appointment;
import com.fatserver.entity.Comment;
import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import com.fatserver.dto.CommentForm;
import com.fatserver.service.AppointmentService;
import com.fatserver.service.CommentsService;
import com.fatserver.service.QuestionService;
import com.fatserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 22.03.2018.
 */

@RestController
public class CommentController {

    @Autowired
    UserService userService;

    @Autowired
    CommentsService commentsService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AppointmentService appointmentService;



    @GetMapping(value = "/getCommentsOfCurrentQuestion{id}")
    public List<CommentForm> getComments(@PathVariable String  id){
        System.out.println("get comments method " + id);
        List<CommentForm> commentForms = new ArrayList<>();
        User user;
        CommentForm commentForm;
        for (Comment com: questionService.findOne(Long.decode(id)).getCommentsList()) {
            user = userService.findOne(com.getUserId());
            commentForm = new CommentForm();
            commentForm.setComment(new CommentDTO(com));
            commentForm.setUserName(user.getName());
            commentForm.setUserSurname(user.getFamilyName());
            commentForms.add(commentForm);
        }
        return commentForms;
    }



    @PostMapping(value = "/sendNewComment{id}")
    public String sendedComment(@RequestBody Comment comment, @PathVariable Long id){

        System.out.println("Works!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(comment.getTextComment());

        Question q = questionService.findOne(id);
        comment.setQuestion_com(q);
        commentsService.save(comment);
        q.getCommentsList().add(comment);

        questionService.update(q);

        return "OK";
    }

//    @PostMapping(value = "/checkIfTwoUsersAreContacted")
//    public Boolean checkIfTwoUsersAreContacted(@RequestParam("personWhoAskedQuestion") Long personWhoAskedQuestion,
//                                               @RequestParam("personWhoLeftComment") Long personWhoLeftComment){
//
//        List<Appointment> appointmentList = appointmentService.findAll();
//        for (Appointment app:
//             appointmentList) {
//            if(app.getEmployer().getId().equals(personWhoAskedQuestion) && app.getEmployee().getId().equals(personWhoLeftComment)){
//                return true;
//            }
//        }
//
//        return false;
//    }

}
