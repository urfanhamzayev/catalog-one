package com.catalog.one.monitoring.model;

public class HystrixCommandStats {

    private int currentConcurrentExecutionCount ;

    private String commandGroup;

    private String commandKey ;
    private int  executionTimeMean ;
    private Long errorCount ;
    private  Long totalCount ;
    private  int errorPercentage ;
    private int totalTimeMean ;

    public int getCurrentConcurrentExecutionCount() {
        return currentConcurrentExecutionCount;
    }

    public void setCurrentConcurrentExecutionCount(int currentConcurrentExecutionCount) {
        this.currentConcurrentExecutionCount = currentConcurrentExecutionCount;
    }

    public String getCommandGroup() {
        return commandGroup;
    }

    public void setCommandGroup(String commandGroup) {
        this.commandGroup = commandGroup;
    }

    public String getCommandKey() {
        return commandKey;
    }

    public void setCommandKey(String commandKey) {
        this.commandKey = commandKey;
    }

    public int  getExecutionTimeMean() {
        return executionTimeMean;
    }

    public void setExecutionTimeMean(int executionTimeMean) {
        this.executionTimeMean = executionTimeMean;
    }

    public Long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Long errorCount) {
        this.errorCount = errorCount;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public int getErrorPercentage() {
        return errorPercentage;
    }

    public void setErrorPercentage(int errorPercentage) {
        this.errorPercentage = errorPercentage;
    }

    public int getTotalTimeMean() {
        return totalTimeMean;
    }

    public void setTotalTimeMean(int totalTimeMean) {
        this.totalTimeMean = totalTimeMean;
    }

    @Override
    public String toString() {
        return "HystrixCommandStats{" +
                "currentConcurrentExecutionCount=" + currentConcurrentExecutionCount +
                ", commandGroup='" + commandGroup + '\'' +
                ", commandKey='" + commandKey + '\'' +
                ", executionTimeMean=" + executionTimeMean +
                ", errorCount=" + errorCount +
                ", totalCount=" + totalCount +
                ", errorPercentage=" + errorPercentage +
                ", totalTimeMean=" + totalTimeMean +
                '}';
    }
}
