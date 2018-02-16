package com.fatserver.service;

import com.fatserver.entity.Skill;
import com.fatserver.entity.User;

import java.util.List;

/**
 * Created by Victor on 16.02.2018.
 */
public interface SkillService {

    void save(Skill skill);

    List<Skill> findAll();

    Skill findOne(Long id);

    void delete(Long  id);

    void update(Skill skill);


}
