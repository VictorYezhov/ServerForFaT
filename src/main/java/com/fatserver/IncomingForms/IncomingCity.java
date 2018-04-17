package com.fatserver.IncomingForms;

/**
 * Created by Victor on 17.04.2018.
 */
public class IncomingCity {

    private Long id;
    private IncomingCountry country;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IncomingCountry getCountry() {
        return country;
    }

    public void setCountry(IncomingCountry country) {
        this.country = country;
    }

    public IncomingCountry getIncomingCountry() {
        return country;
    }

    public void setIncomingCountry(IncomingCountry incomingCountry) {
        this.country = incomingCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
