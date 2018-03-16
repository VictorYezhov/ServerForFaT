package com.fatserver.dao;

import com.fatserver.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Victor on 16.03.2018.
 */
public interface JobPositionDao extends JpaRepository<Position, Long> {
}
