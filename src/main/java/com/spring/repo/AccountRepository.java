package com.spring.repo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query(value = "select max(accountNo) as accountNo from Account a")
	String getNullAccountNo();

	@Query(value = "select max(accountNo) as accountNo from Account a")
	int getMaxAccountNo();
	
	@Modifying
	@Query(value="update Account a set a.balance=a.balance + ?2  where a.accountNo=?1")
	void toAccountTransaction(long toaccount, BigDecimal amount) ;
	
	@Modifying
	@Query(value="update Account a set a.balance=a.balance - ?2  where a.accountNo=?1")
	void fromAccountTransaction(long fromaccount, BigDecimal amount) ;

}
