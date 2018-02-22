package com.fatserver.dao;

import com.fatserver.entity.Job;
import com.fatserver.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobDao extends JpaRepository<Job, Long> {



}
