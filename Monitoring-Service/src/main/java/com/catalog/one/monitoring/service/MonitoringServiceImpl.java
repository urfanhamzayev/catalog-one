package com.catalog.one.monitoring.service;

import com.catalog.one.monitoring.Repository.MonitoringDetailsRepository;
import com.catalog.one.monitoring.Repository.MonitoringRepository;
import com.catalog.one.monitoring.entity.MonitoringTransaction;
import com.catalog.one.monitoring.entity.MonitoringTransactionDetail;
import com.catalog.one.monitoring.exception.MicroserviceNotFoundException;
import com.catalog.one.monitoring.model.MonitoringTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MonitoringServiceImpl implements MonitoringService {

    @Autowired
    MonitoringRepository monitoringRepository;

    @Autowired
    MonitoringDetailsRepository monitoringDetailsRepository;

    @Override
    public void save(MonitoringTransaction monitoringTransaction) {
        monitoringRepository.save(monitoringTransaction);
    }

    @Override
    public void updateByMicroserviceId(long microServiceId) {
        monitoringRepository.delete(microServiceId);
    }

    @Override
    public List<MonitoringTransaction> getAllMonitoringTransactionList() {
        return monitoringRepository.findAll();
    }

    @Override
    public MonitoringTransaction getMonitoringTransactionById(long microServiceId) {
        return monitoringRepository.findById(microServiceId).orElseThrow(MicroserviceNotFoundException::new);
    }

    @Override
    public List<MonitoringTransactionDetail> getAllMonitoringDetailsOfTransactionList() {
        List<MonitoringTransactionDetail> test = monitoringDetailsRepository.findAll();
        return test;
    }

    @Override
    public MonitoringTransactionResponse getAllMonitoringDetailsOfTransactionById(long microServiceId) {

        List<MonitoringTransactionDetail> monitoringTransactionDetails = monitoringDetailsRepository.findById(microServiceId);
        String microserviceName = monitoringRepository.findById(microServiceId).isPresent()?monitoringRepository.findById(microServiceId).get().getName():"ALREADY DEREGISTERED";

        long count = monitoringTransactionDetails.stream().filter(t->t.getLastUpTime()==null).count();

        if(count>0)
            return new MonitoringTransactionResponse(microServiceId,microserviceName,0,"SYSTEM_DOWN");


        long downTimePeriod = monitoringTransactionDetails.stream().mapToLong(transaction->(transaction.getLastUpTime().getNano()-transaction.getLastDownTime().getNano())).sum();

        return new MonitoringTransactionResponse(microServiceId,microserviceName,downTimePeriod,"NOW_RUNNING");
    }

    @Override
    public void deleteMonitoringTransactionDetailsById(String microServiceId) {
        monitoringDetailsRepository.deleteById(microServiceId) ;
    }

    @Override
    public void deleteMonitoringTransaction() {
        monitoringRepository.deleteAll();
    }
}
