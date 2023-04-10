package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.route.model.RoutePointDTO;
import com.example.demo.route.service.RouteService;

@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;

	@GetMapping("/vehicle/{vehicleId}/route_points")
	public ResponseEntity<?> findAllByVehicleAndDateInterval(@PathVariable("vehicleId") UUID vehicleId,
			@RequestParam("startDate") long startDate, @RequestParam("endDate") long endDate, @RequestParam("geo") boolean geo) {
		return routeService.findAllByVehicleAndDateInterval(vehicleId, startDate, endDate, geo);
	}

}
