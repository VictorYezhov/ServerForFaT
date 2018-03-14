package com.fatserver.service;

import com.fatserver.entity.City;
import com.fatserver.entity.Country;

import java.util.List;

/**
 * Created by Victor on 14.03.2018.
 */
public interface CountryService {

    void save(Country job);

    List<Country> findAll();

    Country findOne(Long id);

    void delete(Long  id);

    void update(Country job);


}
