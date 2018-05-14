package com.fatserver.dao;

import com.fatserver.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 14.05.2018.
 */
public interface CategoryDao extends JpaRepository<Category, Long>{


}
