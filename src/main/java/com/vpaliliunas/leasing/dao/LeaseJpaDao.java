package com.vpaliliunas.leasing.dao;

import com.vpaliliunas.leasing.entity.Lease;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class LeaseJpaDao implements LeaseDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Lease findById(Long id) {
        return entityManager.find(Lease.class, id);
    }

    @Override
    public void save(Lease lease) {
        entityManager.persist(lease);
    }

    @Override
    public void update(Lease lease) {
        entityManager.merge(lease);
    }

    @Override
    public void delete(Lease lease) {
        entityManager.remove(lease);
    }
}
