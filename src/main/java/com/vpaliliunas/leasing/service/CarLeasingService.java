package com.vpaliliunas.leasing.service;

import com.vpaliliunas.leasing.dao.LeaseDao;
import com.vpaliliunas.leasing.entity.Lease;
import com.vpaliliunas.leasing.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.function.Function;

@Service
public class CarLeasingService {

    private static final String APPROVED = "Approved";
    private static final String REJECTED = "Rejected";

    private final BigDecimal incomeLimit = BigDecimal.valueOf(600);

    private LeaseDao leaseDao;

    /**
     * Calculates family income and accepts of rejects leasing application depending on income.
     * Persist lease application in database
     *
     * @param lease car leasing application
     */
    public void applyCarLeasing(Lease lease) {
        BigDecimal familyIncome = calculateFamilyIncome(lease);

        if (familyIncome.compareTo(incomeLimit) >= 0) {
            lease.setCreditStatus(APPROVED);
        } else {
            lease.setCreditStatus(REJECTED);
        }
        leaseDao.save(lease);
    }

    /**
     * Retrieves car leasing application by Id
     *
     * @param id ID of application
     * @return car leasing application
     */
    public Lease getCreditApplicationId(Long id) {
        return leaseDao.findById(id);
    }

    private BigDecimal calculateFamilyIncome(Lease lease) {
        BigDecimal familyIncome = BigDecimal.ZERO;
        familyIncome = familyIncome.add(lease.getPerson().getIncome());
        Function<Person, BigDecimal> totalMapper = coApplicant -> coApplicant.getIncome();
        familyIncome = familyIncome.add(lease.getCoApplicants().stream()
                .map(totalMapper)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        return familyIncome;
    }

    @Autowired
    public void setLeaseDao(LeaseDao leaseDao) {
        this.leaseDao = leaseDao;
    }
}
