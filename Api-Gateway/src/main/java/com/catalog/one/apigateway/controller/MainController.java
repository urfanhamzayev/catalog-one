package com.catalog.one.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MainController {
	
	@Autowired
    RestTemplate restTemplate;
 
    @RequestMapping(value = "/billDetails/{billId}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String billing(@PathVariable int billId)
    {
        System.out.println("Getting Bill details for " + billId);
 
        String response = restTemplate.exchange("http://billing-service/findBillDetails/{billId}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, billId).getBody();
 
        System.out.println("Response Body " + response);
 
        return "Bill Id -  " + billId + " [ Bill Details " + response+" ]";
    }
    
    public String  fallbackMethod(int billId){
    	
    	return "Fallback response:: No bill details available temporarily";
    }

    @RequestMapping(value = "/monitoring/{microServiceId}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethodMonitoring")
    public String monitoring(@PathVariable int microServiceId)
    {
        System.out.println("Getting Bill details for " + microServiceId);

        String response = restTemplate.exchange("http://monitoring-service/monitoring/get/{microServiceId}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, microServiceId).getBody();

        System.out.println("Response Body " + response);

        return "Microservice  Id -  " + microServiceId + " [ Microservice Details " + response+" ]";
    }

    public String  fallbackMethodMonitoring(int microServiceId){

        return "Fallback response:: No Microservice details available temporarily";
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
