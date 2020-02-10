package com.catalog.one.monitoring.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(name = "MONITORING_TRANSACTION_DETAILS")
public class MonitoringTransactionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    @ApiModelProperty(notes = "The Microservice Detail Transaction Id .")
    private long transactionId;

    @NotNull
    @Column(name = "MICROSERVICE_ID")
    @ApiModelProperty(notes = "The Microservice Monitoring Id .")
    private long id;

    @Column(name="DOWN_TIME", nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @ApiModelProperty(notes = "The Microservice Detail Down Time date  .")
    private ZonedDateTime lastDownTime ;

    @Column(name="UP_TIME", nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @ApiModelProperty(notes = "The Microservice Detail Up Time date  .")
    private ZonedDateTime lastUpTime ;

    public MonitoringTransactionDetail() {
    }

    public MonitoringTransactionDetail(long id, ZonedDateTime lastDownTime, ZonedDateTime lastUpTime) {
        this.id = id;
        this.lastDownTime = lastDownTime;
        this.lastUpTime = lastUpTime;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public long  getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getLastDownTime() {
        return lastDownTime;
    }

    public void setLastDownTime(ZonedDateTime lastDownTime) {
        this.lastDownTime = lastDownTime;
    }

    public ZonedDateTime getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(ZonedDateTime lastUpTime) {
        this.lastUpTime = lastUpTime;
    }


}
