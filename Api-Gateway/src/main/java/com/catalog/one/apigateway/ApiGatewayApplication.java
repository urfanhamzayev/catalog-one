package com.catalog.one.apigateway;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Scheduled(fixedRate = 1000)
	public void something() {
		final HystrixCommandMetrics metrics = HystrixCommandMetrics.getInstance(HystrixCommandKey.Factory.asKey("request"));

		if (metrics != null) { // metrics will be null until command is first used

			System.out.println("Urfan "+metrics.getExecutionTimeMean());

			/*LOGGER.info("command [{}]: execTime [{}] errors [{}]/[{}]", metrics.getCommandKey().name(),
					metrics.getExecutionTimeMean(),
					metrics.getHealthCounts().getErrorCount(),
					metrics.getHealthCounts().getTotalRequests());*/
		}
	}

}
