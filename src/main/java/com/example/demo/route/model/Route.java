package com.example.demo.route.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.demo.vehicle.model.Vehicle;

@Entity
public class Route {

	@Id
	@GeneratedValue
	private UUID uuid;
	
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RoutePoint> routePoints = new ArrayList<RoutePoint>();
	
	@OneToOne
	private Vehicle vehicle;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public List<RoutePoint> getRoutePoints() {
		return routePoints;
	}

	public void setRoutePoints(List<RoutePoint> routePoints) {
		this.routePoints = routePoints;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
}