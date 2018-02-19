package com.fatserver.service;

import com.fatserver.dao.CategoryDao;
import com.fatserver.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 19.02.2018.
 */
@Service
public class CateoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findOne(Integer id) {
        return categoryDao.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.delete(id);

    }

    @Override
    public void update(Category category) {

        categoryDao.save(category);
    }
}
