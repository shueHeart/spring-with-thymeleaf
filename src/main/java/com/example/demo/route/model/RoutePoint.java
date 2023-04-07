package com.example.demo.route.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.geo.Point;

@Entity
public class RoutePoint extends Point{
	
	@Id
	@GeneratedValue
	private UUID uuid;
	
	private double x;
	
	private double y;
	
	@ManyToOne
    @JoinColumn(name = "route_id")
	private Route route;
	
	public RoutePoint(double x, double y) {
		super(x, y);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
}
