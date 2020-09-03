package com.vpaliliunas.leasing.dao;

import com.vpaliliunas.leasing.entity.Lease;

public interface LeaseDao {

    Lease findById(Long id);

    void save(Lease entity);

    void update(Lease entity);

    void delete(Lease entity);

}
