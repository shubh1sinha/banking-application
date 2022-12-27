package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.SavingsAccount;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Integer> {

}
