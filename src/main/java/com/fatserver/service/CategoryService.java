package com.fatserver.service;

import com.fatserver.entity.Category;
import com.fatserver.entity.Question;

import java.util.List;

/**
 * Created by Victor on 19.02.2018.
 */
public interface CategoryService {

    void save(Category category);

    List<Category> findAll();

    Category findOne(Integer id);

    void delete(Integer  id);

    void update(Category category);


}
