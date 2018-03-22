package com.fatserver.service;

import com.fatserver.entity.City;
import com.fatserver.entity.Comment;

import java.util.List;

/**
 * Created by Victor on 22.03.2018.
 */
public interface CommentsService {

    void save(Comment comment);

    List<Comment> findAll();

    Comment findOne(Long id);

    void delete(Long  id);

    void update(Comment comment);
}
