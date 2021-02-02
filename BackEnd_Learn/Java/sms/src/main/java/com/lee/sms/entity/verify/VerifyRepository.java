package com.lee.sms.entity.verify;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifyRepository extends CrudRepository<Verify, String> {
}
