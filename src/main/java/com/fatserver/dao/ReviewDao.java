package com.fatserver.dao;

import com.fatserver.entity.Review;
import com.fatserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Victor on 16.05.2018.
 */
public interface ReviewDao extends JpaRepository<Review, Long> {


    List<Review> findAllByAbout(User user);

}
