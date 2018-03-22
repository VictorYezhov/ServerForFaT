package com.fatserver.controlller;

import com.fatserver.entity.Country;
import com.fatserver.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Victor on 22.03.2018.
 */
@RestController
public class CountryController {

    @Autowired
    CountryService countryService;


    @GetMapping("/getAllCountries")
    public List<Country> getAllCountries(){
        return countryService.findAll();
    }





}
