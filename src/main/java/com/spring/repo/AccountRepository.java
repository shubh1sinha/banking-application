package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query(value = "select max(accountNo) as accountNo from Account a")
	String getNullAccountNo();

	@Query(value = "select max(accountNo) as accountNo from Account a")
	int getMaxAccountNo();

}
