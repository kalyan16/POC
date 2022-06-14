package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Watch;

public interface WatchRepository extends JpaRepository<Watch, Integer> {

}
