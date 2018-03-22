package com.fatserver.service;

import com.fatserver.dao.CommentDao;
import com.fatserver.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 22.03.2018.
 */
@Service
public class CommentServiceImpl implements CommentsService {

    @Autowired
    CommentDao  commentDao;

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);

    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public Comment findOne(Long id) {
        return commentDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
           commentDao.delete(id);
    }

    @Override
    public void update(Comment comment) {
            commentDao.save(comment);
    }
}
