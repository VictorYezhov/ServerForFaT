package com.fatserver.dao;

import com.fatserver.entity.City;
import com.fatserver.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Victor on 14.03.2018.
 */
public interface CityDao extends JpaRepository<City, Long> {

    @Query("select c from City c left join fetch c.country co where co.id=:id and c.name=:name")
    City findCityByNameandAndCountry(@Param("name") String  name, @Param("id") Long id);
}
