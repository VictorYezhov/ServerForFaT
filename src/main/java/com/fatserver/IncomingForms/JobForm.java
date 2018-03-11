package com.fatserver.IncomingForms;

import com.fatserver.entity.Type;

/**
 * Class represents job that client side appilication send to server
 */
public class JobForm {
    private Long id;
    private String name;
    private Type type;
    private String description;

    public JobForm() {
    }

    public JobForm(String name) {
        this.name = name;
    }

    public JobForm(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public JobForm(String name, Type type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
