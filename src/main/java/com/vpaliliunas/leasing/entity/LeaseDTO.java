package com.vpaliliunas.leasing.entity;

public class LeaseDTO {

    private Long applicationId;
    private String leasingDecisionStatus;
    private Vehicle vehicle;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getLeasingDecisionStatus() {
        return leasingDecisionStatus;
    }

    public void setLeasingDecisionStatus(String leasingDecisionStatus) {
        this.leasingDecisionStatus = leasingDecisionStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}