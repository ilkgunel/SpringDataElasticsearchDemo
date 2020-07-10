package com.ilkaygunel.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ilkaygunel.model.Driver;
import com.ilkaygunel.service.DriverService;

@RestController
@RequestMapping(value = "/api")
public class RestEndPoints {

	@Autowired
	private DriverService driverService;

	@RequestMapping(method = RequestMethod.GET, value = "/drivers")
	public ResponseEntity<List<Driver>> allDrivers() {
		List<Driver> allDrivers = driverService.allDrivers();
		return new ResponseEntity<List<Driver>>(allDrivers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/drivers")
	public ResponseEntity<String> postDriver(@RequestBody Driver driver) {
		driverService.saveDriver(driver);
		return new ResponseEntity<String>("Kayıt İşlemi Başarılı", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/drivers/{id}")
	public ResponseEntity<String> putDriver(@PathVariable("id") String id, @RequestBody Driver driverForUpdate) {
		driverService.updateDriver(id, driverForUpdate);
		return new ResponseEntity<String>("Güncelleme İşlemi Başarılı", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/drivers/{id}")
	public ResponseEntity<String> deleteDriver(@PathVariable("id") String id) {
		driverService.deleteDriver(id);
		return new ResponseEntity<String>("Sime İşlemi Başarılı", HttpStatus.OK);
	}
}
