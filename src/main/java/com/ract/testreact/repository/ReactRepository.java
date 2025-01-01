package com.ract.testreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ract.testreact.entity.ReactEntity;

@Repository
public interface ReactRepository extends JpaRepository<ReactEntity, Long>{

}