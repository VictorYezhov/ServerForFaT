package com.fatserver.dto;

import com.fatserver.entity.Category;

/**
 * Created by Victor on 14.05.2018.
 */
public class CategotryDTO {

    private Long id;
    private String name;


    public CategotryDTO() {
    }

    public CategotryDTO(Category category) {
        id = category.getId();
        name = category.getName();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
