package com.catalog.one.monitoring.controller;

import com.catalog.one.monitoring.Repository.MonitoringDetailsRepository;
import com.catalog.one.monitoring.Repository.MonitoringRepository;
import com.catalog.one.monitoring.entity.MonitoringTransaction;
import com.catalog.one.monitoring.entity.MonitoringTransactionDetail;
import com.catalog.one.monitoring.model.HystrixCommandStats;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Monitoring Hystrix Listener API")
@RequestMapping("/hystrix")
public class MonitoringHystrixListenerController {

    @Autowired
    MonitoringRepository monitoringRepository;

    @Autowired
    MonitoringDetailsRepository monitoringDetailsRepository;

    @ApiOperation(value = "Processing of hystrix event .")
    @PostMapping("process")
    @ResponseStatus(HttpStatus.CREATED)
    public void processHystrixMetrics(@Valid @RequestBody List<HystrixCommandStats> hystrixCommandStatsList) {
        for (HystrixCommandStats commandStat : hystrixCommandStatsList) {
            Optional<MonitoringTransaction> monitoringTransaction = monitoringRepository.findByName(commandStat.getCommandKey().toUpperCase());
            if (monitoringTransaction.isPresent()) {
                Optional<MonitoringTransactionDetail> monitoringTransactionDetailOptional = monitoringDetailsRepository.findByIdOrderByTransactionId(monitoringTransaction.get().getId());
                if (monitoringTransactionDetailOptional.isPresent()) {
                    if (commandStat.getErrorCount() > 0) {
                        if (monitoringTransactionDetailOptional.get().getLastUpTime() != null) {
                            MonitoringTransactionDetail monitoringTransactionDetail1 = new MonitoringTransactionDetail(monitoringTransaction.get().getId(), ZonedDateTime.now(), null);
                            monitoringDetailsRepository.save(monitoringTransactionDetail1);
                        }
                    } else {
                        if (monitoringTransactionDetailOptional.get().getLastUpTime() == null) {
                           monitoringDetailsRepository.updateUpTimeOfMicroserviceById(monitoringTransaction.get().getId(),ZonedDateTime.now());
                        }
                    }
                }else {
                    if (commandStat.getErrorCount() > 0) {
                        MonitoringTransactionDetail monitoringTransactionDetail1 = new MonitoringTransactionDetail(monitoringTransaction.get().getId(), ZonedDateTime.now(), null);
                        monitoringDetailsRepository.save(monitoringTransactionDetail1);
                    }
                }
            }
        }
    }
}
