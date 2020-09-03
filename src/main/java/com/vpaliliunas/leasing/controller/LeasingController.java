package com.vpaliliunas.leasing.controller;

import com.vpaliliunas.leasing.entity.Lease;
import com.vpaliliunas.leasing.entity.LeaseDTO;
import com.vpaliliunas.leasing.service.CarLeasingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/leasing/v1")
public class LeasingController {

    private CarLeasingService carLeasingService;

    /**
     * POST endpoint to apply for car leasing
     *
     * @param lease application for car leasing details
     * @return leasing decision status status and vehicle details
     */
    @PostMapping(value = "/applyLease", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity applyLease(@RequestBody Lease lease) {

        carLeasingService.applyCarLeasing(lease);

        return new ResponseEntity<LeaseDTO>(mapLeaseDTO(lease), HttpStatus.ACCEPTED);
    }

    /**
     * GET endpoint to retrieve credit application status by application id
     *
     * @param id of credit application
     * @return credit application status
     */
    @GetMapping(value = "/creditApplicationStatus/{id}")
    public ResponseEntity getCreditApplication(@PathVariable Long id) {
        Lease lease = carLeasingService.getCreditApplicationId(id);

        if (lease == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<String>(lease.getCreditStatus(), HttpStatus.ACCEPTED);
    }

    private LeaseDTO mapLeaseDTO(Lease lease) {
        LeaseDTO leaseDTO = new LeaseDTO();
        leaseDTO.setApplicationId(lease.getId());
        leaseDTO.setLeasingDecisionStatus(lease.getCreditStatus());
        leaseDTO.setVehicle(lease.getVehicle());
        return leaseDTO;
    }

    @Autowired
    public void setCarLeasingService(CarLeasingService carLeasingService) {
        this.carLeasingService = carLeasingService;
    }
}
