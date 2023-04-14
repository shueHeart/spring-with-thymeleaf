package com.example.demo.route.model;

import java.util.UUID;

public class RouteForVehicleDTO {
	private UUID uuid;
	
	private long startDate;
	
	private long endDate;

	private RoutePointWithAddressDTO startPoint;
	
	private RoutePointWithAddressDTO endPoint;
	
	private UUID vehicleId;
	
	private RouteForVehicleDTO (Route route) {
		
		this.uuid = route.getUuid();
		this.startDate = route.getStartDate();
		this.endDate = route.getEndDate();
		this.vehicleId = route.getVehicle().getUuid();
//		super(route);
		this.setStartPoint(RoutePointWithAddressDTO.fromRoutePoint(route.getRoutePoints().get(0)));
		this.setEndPoint(RoutePointWithAddressDTO.fromRoutePoint(route.getRoutePoints().get(route.getRoutePoints().size() - 1)));
	}
	
	public static RouteForVehicleDTO fromRoute (Route route) {
		return new RouteForVehicleDTO(route);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public UUID getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(UUID vehicleId) {
		this.vehicleId = vehicleId;
	}

	public RoutePointWithAddressDTO getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(RoutePointWithAddressDTO endPoint) {
		this.endPoint = endPoint;
	}

	public RoutePointWithAddressDTO getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(RoutePointWithAddressDTO startPoint) {
		this.startPoint = startPoint;
	}
}
