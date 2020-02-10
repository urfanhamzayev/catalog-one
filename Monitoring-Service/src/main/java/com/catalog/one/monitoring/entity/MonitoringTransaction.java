package com.catalog.one.monitoring.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MONITORING_TRANSACTION")
public class MonitoringTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The Microservice Transaction Id .")
    private Long id;

    @NotNull
    @Size(min = 5)
    @Column(name = "MICROSERVICE_NAME")
    @ApiModelProperty(notes = "The Microservice Name .")
    private String name ;


    @NotNull
    @Size(min = 2)
    @Column(name = "STATUS")
    @ApiModelProperty(notes = "The Microservice Status .")
    private String status ;

    public MonitoringTransaction() {
    }

    public MonitoringTransaction(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MonitoringTransaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
