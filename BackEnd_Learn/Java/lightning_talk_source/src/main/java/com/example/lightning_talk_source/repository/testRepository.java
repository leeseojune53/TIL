package com.example.lightning_talk_source.repository;

import com.example.lightning_talk_source.model.testModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testRepository extends JpaRepository<testModel, Long>{}
