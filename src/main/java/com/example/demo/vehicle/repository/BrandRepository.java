package com.example.demo.vehicle.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vehicle.model.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, UUID> {

	public List<Brand> findAll();
	
}
