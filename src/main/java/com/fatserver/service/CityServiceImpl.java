package com.fatserver.service;

import com.fatserver.dao.CityDao;
import com.fatserver.entity.City;
import com.fatserver.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 14.03.2018.
 */
@Service
public class CityServiceImpl implements CityService {


    @Autowired
    CityDao cityDao;


    @Override
    public void save(City city) {
        cityDao.save(city);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public City findOne(Long id) {
        return cityDao.findOne(id);
    }

    @Override
    public void delete(Long id) {

        cityDao.delete(id);
    }

    @Override
    public void update(City city) {

        cityDao.save(city);
    }

    @Override
    public City findCityByName(String name,  Long id) {
        return cityDao.findCityByNameandAndCountry(name, id);
    }
}
