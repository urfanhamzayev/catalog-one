package com.catalog.one.monitoring.model;

public class MonitoringTransactionResponse {

    private long id ;
    private String name;
    private long sec ;
    private String status ;

    public MonitoringTransactionResponse(long id, String  name, long sec,String status) {
        this.id = id;
        this.name = name;
        this.sec = sec;
        this.status = status;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSec() {
        return sec;
    }

    public void setSec(long sec) {
        this.sec = sec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
