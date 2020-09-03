package com.vpaliliunas.leasing.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lease extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lease_id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleLease_id")
    private Vehicle vehicle;

    @Column
    private BigDecimal requestedAmount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "coApplicant_id")
    private List<Person> coApplicants;

    @Column
    private String creditStatus;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public List<Person> getCoApplicants() {
        if (coApplicants == null) {
            coApplicants = new ArrayList<>();
        }
        return coApplicants;
    }

    public void setCoApplicants(List<Person> coApplicants) {
        this.coApplicants = coApplicants;
    }

    public String getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(String creditStatus) {
        this.creditStatus = creditStatus;
    }
}
