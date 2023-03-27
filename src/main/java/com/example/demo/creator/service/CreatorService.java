package com.example.demo.creator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.creator.model.Creator;
import com.example.demo.driver.model.Driver;
import com.example.demo.enterprise.model.Enterprise;
import com.example.demo.manager.model.Manager;
import com.example.demo.vehicle.model.Vehicle;

@Service
public class CreatorService {

	private final String[] colors = new String[] { "Белый", "Черный", "Красный", "Синий", "Зеленый", "Бежевый",
			"Бежевый", "Сиреневый", "Графит" };

	private final String[] names = new String[] { "Алексей", "Максим", "Гай", "Кристобаль", "Янус", "Константин",
			"Яков", "Александр", "Виктор" };

	private final String[] secondNames = new String[] { "Иванов", "Каммеррер", "Гаал", "Хунта", "Полуэктович",
			"Сидоров", "Петров", "Федоров", "Корнеев" };

	public void create(Creator creator, Manager manager) {

		Enterprise enterprise = creator.getEnterprise();

		List<Driver> drivers = new ArrayList<Driver>();

		for (int driverNum = 0; driverNum < creator.getDriverNum(); ++driverNum) {

			Driver driver = new Driver();

			driver.setAge(randomNumber(18) + 18);
			driver.setFirstName(names[randomNumber(names.length - 1)]);
			driver.setLastName(secondNames[randomNumber(secondNames.length - 1)]);
			driver.setSalary(randomNumber(200000) + 120000);
			
			drivers.add(driver);
		}
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		for (int vehicleNum = 0; vehicleNum < creator.getVehicleNum(); ++vehicleNum) {
			
			Vehicle vehicle = new Vehicle();
			
//			vehicle.set
			
			
		}

	}

	public int randomNumber(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must not be negative");
		}

		return new Random().nextInt(n + 1);
	}

}
