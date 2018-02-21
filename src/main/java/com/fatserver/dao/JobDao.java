package com.fatserver.dao;

import com.fatserver.entity.Job;
import com.fatserver.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDao extends JpaRepository<Job, Long> {
}
