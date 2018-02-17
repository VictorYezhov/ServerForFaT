package com.fatserver.IncomingForms;

/**
 * Created by Victor on 17.02.2018.
 */
public class IncomingSkill {

    private Long id;
    private  String name;


    public IncomingSkill() {

    }

    public IncomingSkill(String name) {
        this.name = name;
    }

    public IncomingSkill(Long id, String name) {
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
