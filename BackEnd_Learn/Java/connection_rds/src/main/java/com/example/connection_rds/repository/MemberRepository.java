package com.example.connection_rds.repository;

import com.example.connection_rds.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> { }
