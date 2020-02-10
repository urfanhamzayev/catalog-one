package com.catalog.one.monitoring.service;

import com.catalog.one.monitoring.entity.MonitoringTransaction;
import com.catalog.one.monitoring.entity.MonitoringTransactionDetail;
import com.catalog.one.monitoring.model.MonitoringTransactionResponse;

import java.util.List;

public interface MonitoringService {

    void save(MonitoringTransaction monitoringTransaction);

    void updateByMicroserviceId(long microServiceId);

    Iterable<MonitoringTransaction> getAllMonitoringTransactionList();

    MonitoringTransaction getMonitoringTransactionById(long microServiceId);


    void deleteMonitoringTransaction();

    void deleteMonitoringTransactionDetailsById(String microServiceId);

    List<MonitoringTransactionDetail> getAllMonitoringDetailsOfTransactionList();

    MonitoringTransactionResponse getAllMonitoringDetailsOfTransactionById(long microServiceId);
}
