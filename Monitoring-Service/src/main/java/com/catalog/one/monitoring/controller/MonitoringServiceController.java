package com.catalog.one.monitoring.controller;


import com.catalog.one.monitoring.entity.MonitoringTransaction;
import com.catalog.one.monitoring.entity.MonitoringTransactionDetail;
import com.catalog.one.monitoring.model.MonitoringTransactionResponse;
import com.catalog.one.monitoring.service.MonitoringServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Monitoring Request API")
@RequestMapping("/monitoring")
public class MonitoringServiceController {

	@Autowired
	MonitoringServiceImpl monitoringService;

	@PutMapping("register")
	@ApiOperation(value = "Register of microservice .")
	@ResponseStatus(HttpStatus.CREATED)
	public void registerMicroService(@Valid @RequestBody MonitoringTransaction  monitoringTransaction){
		monitoringService.save(monitoringTransaction);
	}

	@DeleteMapping(path= "deregister/{microServiceId}")
	@ApiOperation(value = "Deregister of microservice .")
	@ResponseStatus(HttpStatus.OK)
	public void deregisterMicroService(@PathVariable long microServiceId){
		monitoringService.updateByMicroserviceId(microServiceId);
	}

	@GetMapping(path  = "getAll")
	@ApiOperation(value = "Get All  Microservices .")
	@ResponseStatus(HttpStatus.OK)
	public List<MonitoringTransaction> getAllMicroService(){
		return monitoringService.getAllMonitoringTransactionList();
	}

	@ApiOperation(value = "Get Microservice by id .")
	@GetMapping(path  =  "get/{microServiceId}")
	public MonitoringTransaction getMicroServiceById( @PathVariable long microServiceId) {
		return monitoringService.getMonitoringTransactionById(microServiceId);
	}

	@GetMapping(path  = "getAllDetails")
	@ApiOperation(value = "Get All Details of Microservices .")
	@ResponseStatus(HttpStatus.OK)
	public List<MonitoringTransactionDetail> getAllMonitoringDetailOfMicroService(){
		return monitoringService.getAllMonitoringDetailsOfTransactionList();
	}

	@GetMapping(path  =  "getDetails/{microServiceId}")
	@ApiOperation(value = "Get Microservice Detail by id .")
	public MonitoringTransactionResponse getAllMonitoringDetailOfMicroServiceById(@PathVariable long microServiceId) {
		return monitoringService.getAllMonitoringDetailsOfTransactionById(microServiceId);
	}

	@DeleteMapping(path = "reset/{microServiceId}")
	@ApiOperation(value = "Reset Microservice  by id .")
	@ResponseStatus(HttpStatus.OK)
	public void resetMicroService(@PathVariable String microServiceId ){
		monitoringService.deleteMonitoringTransactionDetailsById(microServiceId);
     }

	@DeleteMapping(path = "resetAll")
	@ApiOperation(value = "Reset All Microservice .")
	@ResponseStatus(HttpStatus.OK)
	public void resetAllMicroService( ){
		monitoringService.deleteMonitoringTransaction();
	}


}
