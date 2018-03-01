package com.fatserver.service;

import com.fatserver.dao.JobDao;
import com.fatserver.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeviceImpl implements JobService {
    @Autowired
    JobDao jobDao;

    @Override
    public void save(Job job) {
        jobDao.save(job);
    }

    @Override
    public List<Job> findAll() {
        return jobDao.findAll();
    }

    @Override
    public Job findOne(Long id) {
        return jobDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        jobDao.delete(id);
    }

    @Override
    public void update(Job job) {
        jobDao.save(job);
    }

    @Override
    public List<Job> findJobsForUser(Long id) {
        return jobDao.findJobsForUser(id);
    }

    @Override
    public Job findJobByName(String name) {
        return jobDao.findJobByName(name);
    }


}
