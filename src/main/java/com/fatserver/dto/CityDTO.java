package com.fatserver.dto;

/**
 * Created by Victor on 17.04.2018.
 */
public class CityDTO {

    private Long id;
    private CountryDTO country;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public CountryDTO getIncomingCountry() {
        return country;
    }

    public void setIncomingCountry(CountryDTO countryDTO) {
        this.country = countryDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
