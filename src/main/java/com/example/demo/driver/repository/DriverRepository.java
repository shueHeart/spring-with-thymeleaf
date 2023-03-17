package com.example.demo.driver.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.driver.model.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, UUID> {

}
