package com.catalog.one.monitoring.Repository;

import com.catalog.one.monitoring.entity.MonitoringTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonitoringRepository extends JpaRepository<MonitoringTransaction, Long> {

    Optional<MonitoringTransaction> findById(Long microServiceId);

    Optional<MonitoringTransaction> findByName(String name);

    void deleteById(String microServiceId);
}
