package com.fatserver.service;

import com.fatserver.entity.Job;

import java.util.List;

public interface JobService  {
    void save(Job job);

    List<Job> findAll();

    Job findOne(Long id);

    void delete(Long  id);

    void update(Job job);
}
