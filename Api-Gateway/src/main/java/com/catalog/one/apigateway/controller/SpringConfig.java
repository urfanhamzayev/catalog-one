package com.catalog.one.apigateway.controller;

import com.netflix.hystrix.HystrixCommandMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Autowired
    RestTemplate restTemplate;

    @Scheduled(fixedDelay = 5000)
    public void scheduleFixedDelayTask() {

        List<HystrixCommandStats> commandStats =  HystrixCommandMetrics.getInstances().stream().map((m) -> {
            final HystrixCommandStats s = new HystrixCommandStats();
            s.setCurrentConcurrentExecutionCount( m.getCurrentConcurrentExecutionCount());
            s.setCommandGroup( m.getCommandGroup().name());
            s.setCommandKey(m.getCommandKey().name());
            s.setExecutionTimeMean( m.getExecutionTimeMean());
            s.setErrorCount(m.getHealthCounts().getErrorCount());
            s.setTotalCount( m.getHealthCounts().getTotalRequests());
            s.setErrorPercentage( m.getHealthCounts().getErrorPercentage());
            s.setTotalTimeMean( m.getTotalTimeMean());

            return s;
        }).collect(Collectors.toList()) ;

        for (HystrixCommandStats commandStat : commandStats) {
            System.out.println("Urfan "+commandStat.toString());
        }
        String response = restTemplate.postForEntity("http://monitoring-service/hystrix/process",commandStats,String.class).getBody();

        System.out.println("Urfan Response"+response);

    }
}
