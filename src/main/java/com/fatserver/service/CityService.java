package com.fatserver.service;

import com.fatserver.entity.City;
import com.fatserver.entity.Job;

import java.util.List;

/**
 * Created by Victor on 14.03.2018.
 */
public interface CityService {

    void save(City job);

    List<City> findAll();

    City findOne(Long id);

    void delete(Long  id);

    void update(City job);

}
