package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Tv;

public interface TvRepository extends JpaRepository<Tv, Integer> {

}
