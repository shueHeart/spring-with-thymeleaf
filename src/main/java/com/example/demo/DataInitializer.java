package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.driver.repository.DriverRepository;
import com.example.demo.vehicle.model.Vehicle;
import com.example.demo.vehicle.repository.BrandRepository;
import com.example.demo.vehicle.repository.VehicleRepository;
import com.example.demo.enterprise.repository.EnterpriseRepository;
import com.example.demo.manager.repository.ManagerRepository;


@Component
public class DataInitializer {
    
	@Autowired
    private VehicleRepository vehicleRepository;
    
	@Autowired
    private BrandRepository brandRepository;
	
	@Autowired
    private DriverRepository driverRepository;
	
	@Autowired
    private EnterpriseRepository EnterpriseRepository;
	
	@Autowired
    private ManagerRepository managerRepository;
	
	
//    @Autowired
//    public DataInitializer(VehicleRepository vehicleRepository) {
//        this.vehicleRepository = vehicleRepository;
//    }
    
    @PostConstruct
    public void initializeData() {
        // Инициализация данных
//        MyData myData1 = new MyData("data1");
//        MyData myData2 = new MyData("data2");
//        myRepository.save(myData1);
//        myRepository.save(myData2);
    }
    
//    private Vehicle createVehicle() {
//    	
//    }
}