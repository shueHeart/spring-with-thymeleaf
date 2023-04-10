package com.example.demo.route.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.route.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, UUID>{

}
