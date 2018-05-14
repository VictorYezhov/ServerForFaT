package com.fatserver.dao;

import com.fatserver.entity.Category;
import com.fatserver.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Victor on 19.02.2018.
 */
public interface QuestionDao extends JpaRepository<Question,Long> {


    List<Question> findQuestionsByCategory(Category category);



}
