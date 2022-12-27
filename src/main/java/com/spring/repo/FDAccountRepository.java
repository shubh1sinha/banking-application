package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.FDAccount;

@Repository
public interface FDAccountRepository extends JpaRepository<FDAccount, Integer> {

}
