package com.fatserver.IncomingForms;

import com.fatserver.entity.City;

import java.util.List;

/**
 * Created by Victor on 17.04.2018.
 */
public class CountryDTO {

    private Long id;
    private String name;
    private String code;
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
