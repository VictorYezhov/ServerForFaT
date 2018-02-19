package com.fatserver.dao;

import com.fatserver.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 19.02.2018.
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {



}
