package com.vpaliliunas.leasing.service;

import com.vpaliliunas.leasing.dao.LeaseDao;
import com.vpaliliunas.leasing.entity.Lease;
import com.vpaliliunas.leasing.entity.Person;
import com.vpaliliunas.leasing.entity.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

public class CarLeasingServiceTest {

    private static final String APPROVED = "Approved";
    private static final String REJECTED = "Rejected";

    @InjectMocks
    private CarLeasingService testObject;

    @Mock
    private LeaseDao leaseDao;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAcceptApplication() {
        Lease lease = createLeaseApplication();
        lease.getPerson().setIncome(BigDecimal.valueOf(400));
        lease.getCoApplicants().get(0).setIncome(BigDecimal.valueOf(400));

        testObject.applyCarLeasing(lease);

        Assert.assertEquals(APPROVED, lease.getCreditStatus());
    }

    @Test
    public void shouldRejectApplication() {
        Lease lease = createLeaseApplication();
        lease.getPerson().setIncome(BigDecimal.valueOf(100));
        lease.getCoApplicants().get(0).setIncome(BigDecimal.valueOf(400));

        testObject.applyCarLeasing(lease);

        Assert.assertEquals(REJECTED, lease.getCreditStatus());
    }

    private Lease createLeaseApplication() {
        Lease lease = new Lease();

        Vehicle vehicle = new Vehicle();
        vehicle.setMake("make");
        vehicle.setModel("model");
        vehicle.setLicensePlate("plate");
        vehicle.setVinNumber("vin");
        lease.setVehicle(vehicle);

        Person person = new Person();
        person.setName("name");
        person.setPersonID("personId");
        lease.setPerson(person);

        Person coApplicant = new Person();
        coApplicant.setName("name");
        coApplicant.setPersonID("personId");
        lease.getCoApplicants().add(coApplicant);

        return lease;
    }
}