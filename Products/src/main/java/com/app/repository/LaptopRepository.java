package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
