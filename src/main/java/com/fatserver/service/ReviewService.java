package com.fatserver.service;

import com.fatserver.entity.Review;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;

import java.util.List;

/**
 * Created by Victor on 16.05.2018.
 */
public interface ReviewService {

    void save(Review review);

    List<Review> findAll();

    Review findOne(Long id);

    void delete(Long  id);

    void update(Review review);

    List<Review> findAllReviewAboutUser(User user);

}
