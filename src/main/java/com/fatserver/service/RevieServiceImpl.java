package com.fatserver.service;

import com.fatserver.dao.ReviewDao;
import com.fatserver.entity.Review;
import com.fatserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 16.05.2018.
 */
@Service
public class RevieServiceImpl implements ReviewService {


    @Autowired
    private ReviewDao reviewDao;

    @Override
    public void save(Review review) {
        reviewDao.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public Review findOne(Long id) {
        return reviewDao.findOne(id);
    }

    @Override
    public void delete(Long id) {

        reviewDao.delete(id);
    }

    @Override
    public void update(Review review) {

        reviewDao.save(review);
    }

    @Override
    public List<Review> findAllReviewAboutUser(User user) {
        return reviewDao.findAllByAbout(user);
    }
}
