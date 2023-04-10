package com.example.demo.route.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.controller.LoginController;
import com.example.demo.geojson.model.GEO;
import com.example.demo.geojson.model.Geometry;
import com.example.demo.geojson.model.Properties;
import com.example.demo.route.model.RoutePoint;
import com.example.demo.route.model.RoutePointDTO;
import com.example.demo.route.repository.RoutePointRepository;
import com.example.demo.vehicle.model.Vehicle;
import com.example.demo.vehicle.repository.VehicleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RouteService {
	
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private RoutePointRepository routePointRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public ResponseEntity<?> findAllByVehicleAndDateInterval(UUID vehicleId, long startDate, long endDate, boolean geo) {
		
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new RuntimeException("Vehicle not found"));
		
		List<RoutePoint> routePoints = routePointRepository.findByRouteVehicleAndVisitDateBetween(vehicle, startDate, endDate);
		
		List<RoutePointDTO> routePointDTOs = routePoints.stream().map(routePoint -> RoutePointDTO.fromVehicle(routePoint)).collect(Collectors.toList());
		
		if (geo) {
			return new ResponseEntity<>(geoBuilder(routePointDTOs, vehicleId), HttpStatus.OK);
		}
		
		log.info(routePoints.size() + "");
		
		return new ResponseEntity<>(routePoints.stream().map(routePoint -> RoutePointDTO.fromVehicle(routePoint)).collect(Collectors.toList()), HttpStatus.OK); 
	}
	
	
	private List<GEO> geoBuilder(List<RoutePointDTO> routePointsDTOs, UUID vehicleId) { 
		
		List<GEO> geos = new ArrayList<GEO>();
		
		for (RoutePointDTO routePointDTO : routePointsDTOs) {
			
			Geometry geometry = new Geometry("RoutePoint", new double[] {routePointDTO.getX(), routePointDTO.getY()});
			Properties properties = new Properties(vehicleId, routePointDTO.getVisitDate());
			
			geos.add(new GEO("RoutePoint", geometry, properties));
			
		}
		
		return geos;
		
	}
}
