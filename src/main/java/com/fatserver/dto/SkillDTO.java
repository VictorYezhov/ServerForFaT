package com.fatserver.dto;

/**
 * Created by Victor on 17.02.2018.
 * Class represents skill that client side appilication send to server
 */
public class SkillDTO {

    private Long id;
    private  String name;


    public SkillDTO() {

    }

    public SkillDTO(String name) {
        this.name = name;
    }

    public SkillDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
