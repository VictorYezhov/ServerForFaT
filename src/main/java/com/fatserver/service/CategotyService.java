package com.fatserver.service;

import com.fatserver.entity.Category;
import com.fatserver.entity.City;

import java.util.List;

/**
 * Created by Victor on 14.05.2018.
 */
public interface CategotyService {

    void save(Category category);

    List<Category> findAll();

    Category findOne(Long id);

    void delete(Long  id);

    void update(Category job);

}
