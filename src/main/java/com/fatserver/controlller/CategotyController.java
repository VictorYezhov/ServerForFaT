package com.fatserver.controlller;

import com.fatserver.IncomingForms.QuestionDTO;
import com.fatserver.entity.Category;
import com.fatserver.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Victor on 14.05.2018.
 */
@RestController
public class CategotyController {

    @Autowired
    private CategoryServiceImpl categoryService;




    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }





}
