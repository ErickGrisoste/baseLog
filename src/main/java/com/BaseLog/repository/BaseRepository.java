package com.BaseLog.repository;

import com.BaseLog.model.Base;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Base, Long> {
}
