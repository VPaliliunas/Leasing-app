package com.vpaliliunas.leasing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Vehicle extends BaseEntity {

    @Column
    private String make;

    @Column
    private String model;

    @Column
    private String vinNumber;

    @Column
    private String licensePlate;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
