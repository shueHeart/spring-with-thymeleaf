package com.example.demo.enterprise.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.enterprise.model.Enterprise;

@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, UUID> {

}
