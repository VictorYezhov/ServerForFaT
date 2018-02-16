package com.fatserver.service;

import com.fatserver.dao.SkillDao;
import com.fatserver.entity.Skill;
import com.fatserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 16.02.2018.
 */
@Service
public class SkillSeviceImpl implements SkillService{

    @Autowired
    SkillDao skillDao;


    @Override
    public void save(Skill skill) {
        skillDao.save(skill);
    }

    @Override
    public List<Skill> findAll() {
        return skillDao.findAll();
    }

    @Override
    public Skill findOne(Long id) {
        return skillDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        skillDao.delete(id);

    }

    @Override
    public void update(Skill skill) {
        skillDao.save(skill);
    }
}
