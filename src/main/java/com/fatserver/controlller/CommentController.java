package com.fatserver.controlller;

import com.fatserver.dto.CommentDTO;
import com.fatserver.entity.Comment;
import com.fatserver.entity.Question;
import com.fatserver.entity.User;
import com.fatserver.dto.CommentForm;
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
//            commentForm.setImage(ImageLoader.loadImageFromFileSystem(user.getPathToImage()).getBody());
            commentForms.add(commentForm);

        }

        return commentForms;
    }




    @PostMapping(value = "/sendNewComment{id}")
    public String sendedComment(@RequestBody Comment comment, @PathVariable Long id){
        comment.setDateTime(new Timestamp(System.currentTimeMillis()));

        System.out.println("Works!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(comment.getTextComment());

        Question q = questionService.findOne(id);
        comment.setQuestion_com(q);
        commentsService.save(comment);
        q.getCommentsList().add(comment);

        questionService.update(q);

        return "OK";
    }

}
