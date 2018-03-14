package com.fatserver.service;

import com.fatserver.dao.CountryDao;
import com.fatserver.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 14.03.2018.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryDao countryDao;


    @Override
    public void save(Country country) {
        countryDao.save(country);
    }

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    @Override
    public Country findOne(Long id) {
        return countryDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        countryDao.delete(id);

    }

    @Override
    public void update(Country country) {
        countryDao.save(country);
    }
}
