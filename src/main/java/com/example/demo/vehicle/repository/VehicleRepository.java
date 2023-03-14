package com.example.demo.vehicle.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vehicle.model.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, UUID> {
	
	public List<Vehicle> findAll();

}
