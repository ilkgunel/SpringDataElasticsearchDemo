package com.ilkaygunel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilkaygunel.model.Driver;
import com.ilkaygunel.repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;

	public List<Driver> allDrivers() {
		List<Driver> allDrivers = new ArrayList<Driver>();

		driverRepository.findAll().forEach(driver -> {
			allDrivers.add(driver);
		});

		return allDrivers;
	}

	public void saveDriver(Driver driver) {
		driverRepository.save(driver);
	}

	public void updateDriver(String key, Driver driverForUpdate) {
		driverRepository.findById(key).ifPresentOrElse(driver -> {
			driver.setName(driverForUpdate.getName());
			driver.setSurname(driverForUpdate.getSurname());
			driver.setTeam(driverForUpdate.getTeam());
			driverRepository.save(driver);
		}, () -> {
			throw new RuntimeException("No Record With This Id!");
		});
	}

	public void deleteDriver(String key) {
		driverRepository.findById(key).ifPresentOrElse(driver -> {
			driverRepository.delete(driver);
		}, () -> {
			throw new RuntimeException("No Record With This Id!");
		});
	}

}
