package com.catalog.one.monitoring.Repository;

import com.catalog.one.monitoring.entity.MonitoringTransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MonitoringDetailsRepository extends JpaRepository<MonitoringTransactionDetail, Long> {

    void deleteById(String microServiceId);

    List<MonitoringTransactionDetail> findById(long microServiceId);

    Optional<MonitoringTransactionDetail> findByIdOrderByTransactionId(long microServiceId);

    @Transactional
    @Modifying
    @Query("UPDATE MonitoringTransactionDetail m set m.lastUpTime = ?2 where m.id = ?1")
    void updateUpTimeOfMicroserviceById(Long id, ZonedDateTime now);
}
